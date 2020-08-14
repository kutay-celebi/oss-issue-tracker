import createPersistedState from "vuex-persistedstate";

export default ({store}) => {
  createPersistedState({
                         key    : "auth",
                         storage: window.sessionStorage,
                         paths  : [
                           "auth"
                         ]
                       })(store)
}
