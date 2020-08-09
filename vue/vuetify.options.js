import dark from "~/dark";

export default {
  // breakpoint: {},
  // icons     : {},
  // lang      : {},
  // rtl   : true,
  // theme     : {}
  customProperties: true,
  theme           : {
    dark  : false,
    themes: {
      light: {
        primary: '#3f51b5',
        secondary: '#b0bec5',
        accent: '#8c9eff',
        error: '#b71c1c',
      },
      dark: {
        primary  : dark,
        secondary : "#E1E2E2",
        // accent: colors.shades.black,
        // error: colors.red.accent3,
        kzProperty: "#3f3"
      },
    }
  },
}
