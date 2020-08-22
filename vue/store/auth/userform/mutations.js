import {initialState} from "~/store/auth/userform/state";
import {updateField}  from "vuex-map-fields";

export default {
  openUpdateForm(state, payload) {
    state.userForm = payload
  },
  closeDialog(state) {
    state.userForm   = initialState.userForm;
    state.formDialog = false;
  },
  openDialog(state) {
    state.formDialog = true;
  },
  setuser(state, payload) {
    state.userForm = payload
  },
  updateField
}
