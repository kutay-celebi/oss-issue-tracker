export default {
  nuxtServerInit ({ commit }, { req }) {
    if (req.session && req.session.username) {
      commit("login", req.session.username)
    }
  },
  login(dispatch, {username, password}) {
    if (username === "admin" && password === "admin") {
      dispatch.commit("login", username)
      this.$router.push("/home")
    }
  },
}
