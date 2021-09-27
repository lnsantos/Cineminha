package dependencies

object BaseDependencies {

    val implementations = arrayListOf(
        Libs.kotlinStdlib,
        Libs.codeKtx,
        Libs.appcompat,
        Libs.lottie,
        Libs.testHamcrest
    )

    val testImplementations = arrayListOf(
        Libs.testJunit,
        Libs.testMockK,
        Libs.testHamcrestLibrary
    )

    val androidTestImplementations = arrayListOf(
        Libs.testJunitExt,
        Libs.testMockkAndroid
    )
}