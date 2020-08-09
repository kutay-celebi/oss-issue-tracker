import {API_SAVE_USER} from "~/common/constant/api/path";

export default {
  async save(dispatch, user) {
    await this.$api.post(API_SAVE_USER,
      user
    ).then(res => {
      alert(res)
    })
              .catch(e => {
                console.log(e);
              })
  },
}
