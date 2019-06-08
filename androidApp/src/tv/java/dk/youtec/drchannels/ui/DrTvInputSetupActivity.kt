package dk.youtec.drchannels.ui

import android.content.ContentUris
import android.content.Intent
import android.media.tv.TvInputInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.tvprovider.media.tv.Channel
import androidx.tvprovider.media.tv.ChannelLogoUtils
import androidx.tvprovider.media.tv.TvContractCompat
import dk.youtec.drchannels.BuildConfig
import dk.youtec.drchannels.R
import dk.youtec.drchannels.util.SharedPreferences
import dk.youtec.drchannels.util.getBitmapFromVectorDrawable
import dk.youtec.drchannels.util.isTv
import org.jetbrains.anko.defaultSharedPreferences

class DrTvInputSetupActivity : AppCompatActivity() {
    private val tag = DrTvInputSetupActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!isTv()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        setupCurrentProgramsPreviewChannel()

        val inputId = getString(R.string.channelInputId)

        val fragment = DrTvInputSetupFragment().apply {
            arguments = intent.extras ?: Bundle()
            arguments.putString(TvInputInfo.EXTRA_INPUT_ID, inputId)
        }

        @Suppress("DEPRECATION")
        fragmentManager.beginTransaction().add(android.R.id.content, fragment).commit()
    }

    private fun setupCurrentProgramsPreviewChannel() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                    && SharedPreferences.getLong(this, "channelId") == 0L) {

                val channel = getChannel()

                val channelUri = contentResolver.insert(
                        TvContractCompat.Channels.CONTENT_URI, channel.toContentValues())

                val channelId = ContentUris.parseId(channelUri)

                ChannelLogoUtils.storeChannelLogo(this,
                        channelId,
                        getBitmapFromVectorDrawable(applicationContext, R.mipmap.ic_launcher))

                TvContractCompat.requestChannelBrowsable(this, channelId)

                defaultSharedPreferences.edit {
                    putLong("channelId", channelId)
                }
            } else {
                Log.d(tag, "Updating current programs preview channel")
                contentResolver.update(
                        TvContractCompat.buildChannelUri(
                                SharedPreferences.getLong(this, "channelId")),
                        getChannel().toContentValues(), null, null)
            }
        } catch (e: Exception) {
            Log.e(tag, "Unable to setup current programs preview channel", e)
        }
    }

    private fun getChannel(): Channel {
        return with(Channel.Builder()) {
            setType(TvContractCompat.Channels.TYPE_PREVIEW)
            setDisplayName(getString(R.string.currentPrograms))
            setAppLinkIntent(Intent(this@DrTvInputSetupActivity,
                    MainActivity::class.java))
            build()
        }
    }
}