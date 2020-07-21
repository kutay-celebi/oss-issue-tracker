import {AUTH_TOKEN_PATH} from "~/common/constant/api/path";

const Cookie = process.client ? require('js-cookie') : undefined
export default {
  async login(dispatch, {username, password}) {
    var urlencoded = new URLSearchParams();
    urlencoded.append("username", username);
    urlencoded.append("password", password);
    urlencoded.append("grant_type", "password");
    await this.$axios.$post(AUTH_TOKEN_PATH, urlencoded,
                            {
                              headers: {
                                "Content-Type" : "application/x-www-form-urlencoded",
                                "Authorization": "Basic dGVzdDoxMjM=" // todo basic token icin yapilari inceleyelim boyle hardcode vermeyelim.
                              },
                            }).then((response) => {
      Cookie.set("auth", response)
      dispatch.commit("login", response)
      this.$router.push("/home")
    }).catch((error) => {
      //todo @kcelebi generic snack error
      console.log(error)
    })
  },

  storeAuth(context, cookie) {
    context.commit("storePayload", cookie)
  },

  clearAuth(dispatch) {
    dispatch.commit("clearAuth")
  }
}
