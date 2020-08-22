import {API_GET_USER_USERNAME_OR_EMAIL, API_SAVE_USER} from "~/common/constant/api/path";

export default {
  openUpdateForm(context, {item}) {
    context.commit("openUpdateForm", item)
  },
  closeDialog(dispatch) {
    dispatch.commit("closeDialog")
    this.$router.push({path: "/user"})
  },
  openDialog(dispatch) {
    dispatch.commit("openDialog")
  },
  setUser(dispatch, user) {
    dispatch.commit("setuser", user)
  },
  async get(dispatch, username) {
    await this.$api.get(API_GET_USER_USERNAME_OR_EMAIL + username)
              .then(res => {
                dispatch.commit("setuser", res.data)
                dispatch.commit("openDialog");
              })
              .catch(e => console.log(e))
  },
  async save(dispatch) {
    await this.$api.$post(API_SAVE_USER, dispatch.state.userForm)
              .then(res => {
                alert(res)
              })
              .catch(e => {
                console.log(e);
              })
  },
}
