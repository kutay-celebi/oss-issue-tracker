export const initialState = {
  userForm    : {
    "email"   : "",
    "enabled" : true,
    "username": "",
    "password": "",
    "person"  : {
      "birthday"            : "",
      "gender"              : "FEMALE",
      "identificationNumber": "",
      "lastName"            : "",
      "midName"             : "",
      "name"                : "",
      "nationality"         : "",
      "title"               : "",
    },
  }

}

export default () => ({
  ...initialState
})
