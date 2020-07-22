// const Cookie = process.client ? require('js-cookie') : undefined
export default {
  defaultLang(context) {
    context.commit("defaultLocale")
  }
}
