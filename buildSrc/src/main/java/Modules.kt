object Modules {

    const val APP = ":app"
    const val BASE = ":base"
    const val UI_SIGN_IN = ":ui:signin"
    const val UI_SIGN_UP = ":ui:signup"

    val uiInjectModules = arrayListOf(
        BASE
    )

    val appInjectModules = arrayListOf(
        BASE,
        UI_SIGN_IN,
        UI_SIGN_UP
    )

    val baseInjectModules = arrayListOf("")

}