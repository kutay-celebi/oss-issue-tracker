import dark              from "~/dark";
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";

const CUSTOM_ICONS = {
  add : { // custom icon I want to use
    component: FontAwesomeIcon,
    props    : {
      icon: ['fas', 'plus']
    }
  },
  user: { // used for the nav-icon by vuetify
    component: FontAwesomeIcon,
    props    : {
      icon: ['fas', 'user']
    }
  },
  edit: { // used for the nav-icon by vuetify
    component: FontAwesomeIcon,
    props    : {
      icon: ['fas', 'edit']
    }
  },
}

export default {
  icons: {
    iconfont: "faSvg",
    values  : CUSTOM_ICONS
  },
  theme: {
    options: {
      customProperties: true,
    },
    dark   : false,
    themes : {
      light: {
        primary  : '#3f51b5',
        secondary: '#b0bec5',
        accent   : '#8c9eff',
        error    : '#b71c1c'
      },
      dark : {
        primary   : dark,
        secondary : "#E1E2E2",
        kzProperty: "#3f3"
      },
    }
  },
}
