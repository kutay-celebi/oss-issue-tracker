const GENDER = Object.freeze({
                               MALE  : {
                                 val: "MALE",
                                 label: "enum.gender.male"
                               },
                               FEMALE: {
                                 val: "FEMALE",
                                 label: "enum.gender.female"
                               }
                             })


export const genderLabel = (gender) => {
  switch (gender) {
    case gender.MALE:
      return "enum.gender.male"
    case gender.FEMALE:
      return "enum.gender.female"

  }
}

export default GENDER;
