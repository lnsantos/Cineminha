object Modules {

    const val APP = ":app"

    const val BASE = ":base"
    const val BASE_CLEAN = ":base-clean"

    // ui flow
    const val UI_SIGN_IN = ":ui:signin"
    const val UI_SIGN_UP = ":ui:signup"
    const val UI_WELCOME = ":ui:welcome"


    val uiInjectModules = arrayListOf(
        BASE,
        BASE_CLEAN
    )

    val appInjectModules = arrayListOf(
        BASE,
        UI_SIGN_IN,
        UI_SIGN_UP,
        UI_WELCOME,
        BASE_CLEAN
    )

    val baseInjectModules = arrayListOf("")

}