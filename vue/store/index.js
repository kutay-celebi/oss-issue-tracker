import Cookies           from 'js-cookie';
const cookieparser = process.server ? require('cookieparser') : undefined

export default {
  actions: {
    nuxtServerInit(context, {req}) {
      if (req.headers.cookie) {
        const parsed = cookieparser.parse(req.headers.cookie);
        const auth  = JSON.parse(parsed.auth);
        console.warn(auth)
        context.commit("auth/storePayload", auth)
      }
    },
  }
}
