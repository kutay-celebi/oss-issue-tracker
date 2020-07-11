export default {
  nuxtServerInit({commit}, {req}) {
    if (req.session && req.session.username) {
      commit("login", req.session.username)
    }
  },
  async login(dispatch, {username, password}) {

    await this.$axios.$post(L)

    if (username === "admin" && password === "admin") {
      dispatch.commit("login", username)
      this.$router.push("/home")
    }
  },
}
