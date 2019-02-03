import dk.youtec.drapi.decryptUri
import org.junit.Test

class UriTests {

    @Test
    fun testDecryptUri() {
        val uri = "01000001806bd05a0130d87190be50fe971fdc3a65face0a3a0bb21709d153305ad5084e6486f0daa597e7c0dade0a07c103d76b8c68d9592783fea739ee43324bbe8413bb4f230800ed02b1dd37a35b5284134d022e66be9a928802c2a0ff5fd77c414fe3d3bc5ec74d13ad55c8219ccb65b2df830d77af42302b54665b6edb32e1352d7d4b74330da724170fddab9ef3d1797c21c6a1c7168a0e7a933056d3060d6f257cffae19196d468d59ff406a125defe5a69ba786c23834efc19cc916d6d8f53bccba7e15d0e0315668ad435a8b336b089c"
        println(decryptUri(uri))
    }

}
