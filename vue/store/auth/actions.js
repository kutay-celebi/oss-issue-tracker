import {AUTH_TOKEN_PATH} from "~/common/constant/api/path";

export default {
  nuxtServerInit ({ commit }, { req }) {
    let auth = null
    if (req.headers.cookie) {
      const parsed = cookieparser.parse(req.headers.cookie)
      try {
        auth = JSON.parse(parsed.auth)
      } catch (err) {
        // No valid cookie found
      }
    }
    commit('setAuth', auth)
  },
  async login(dispatch, {username, password}) {
    var urlencoded = new URLSearchParams();
    urlencoded.append("username", username);
    urlencoded.append("password", password);
    urlencoded.append("grant_type", "password");

    await this.$axios.$post(AUTH_TOKEN_PATH, urlencoded,
                            {
                              headers: {
                                "Content-Type" : "application/x-www-form-urlencoded",
                                "Authorization": "Basic dGVzdDp0ZXN0" // todo basic token icin yapilari inceleyelim boyle hardcode vermeyelim.
                              },
                            }).then((response) => {
      dispatch.commit("login", response)
      this.$router.push("/home")
    }).catch((error) => {
      //  todo generic snack error
      console.log(error.response.data.message)
    })
  },
}
