export default function ({store,redirect}) {
    // console.warn("auth status ", auth.is)
  // if (!store.state.auth.isLogin) {
  //   context.redirect("/")
    // console.warn("yonlendirdi")
  // }
  if (store.state.auth.isLogin === false){
    redirect("/")
  }
}
