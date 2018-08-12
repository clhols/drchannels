package dk.youtec.drchannels.ui

import android.content.ContentUris
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.tv.TvInputInfo
import android.os.Build
import android.os.Bundle
import android.support.media.tv.Channel
import android.support.media.tv.ChannelLogoUtils
import android.support.media.tv.TvContractCompat
import android.support.v7.app.AppCompatActivity
import androidx.core.content.edit
import dk.youtec.drchannels.R
import dk.youtec.drchannels.util.SharedPreferences
import org.jetbrains.anko.defaultSharedPreferences

class DrTvInputSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                && SharedPreferences.getLong(this, "channelId") == 0L) {

            val channel = Channel.Builder()
                    .setType(TvContractCompat.Channels.TYPE_PREVIEW)
                    .setDisplayName(getString(R.string.currentPrograms))
                    .setAppLinkIntent(Intent(this, MainActivity::class.java))
                    .build()

            val channelUri = contentResolver.insert(
                    TvContractCompat.Channels.CONTENT_URI, channel.toContentValues())

            val channelId = ContentUris.parseId(channelUri)

            ChannelLogoUtils.storeChannelLogo(this,
                    channelId,
                    BitmapFactory.decodeResource(resources, R.drawable.ic_channel_logo))

            TvContractCompat.requestChannelBrowsable(this, channelId)

            defaultSharedPreferences.edit {
                putLong("channelId", channelId)
            }
        }
    }
}