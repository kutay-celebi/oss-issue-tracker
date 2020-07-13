const cookieparser   = process.server ? require('cookie') : undefined
export const actions = {
  async nuxtServerInit({commit}, {req}) {
    if (req.headers.cookie) {
      const parsed = cookieparser.parse(req.headers.cookie);
      const auth   = JSON.parse(parsed.auth);
      await commit("auth/storePayload", auth)
    }
  },
}
