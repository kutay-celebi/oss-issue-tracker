import {dark} from "../../@kuartz/colors";
import {orange, red} from "@material-ui/core/colors";

// todo move on redux.
export const defaultThemeConfig = {
    default: {
        props    : {
            // Name of the component ⚛️
            MuiButton: {
                // The default props to change
                disableRipple: true, // No more ripple, on the whole application
                variant      : 'outlined'
            },
            MuiTextField : {
                color    : 'secondary',
                variant  : 'outlined',
                type     : 'input',
                autoFocus: true
            }
        },
        overrides: {
            // todo search it.
        },
        palette  : {
            type      : "light",
            primary   : dark,
            secondary : {
                light: "#E1E2E2", // todo duzenlenecek
                main : "#FB8122", // todo duzenlenecek
                dark : "#af380a", // todo duzenlenecek
            },
            background: {
                paper  : "#FFF", // TODO DUZENLENECEK
                default: "#f7f7f7"  // TODO DUZXENLENECEK
            },
            text      : {
                primary  : "#252f37",
                secondary: "#FB8122"
            },
            error     : red
        },
        status   : {
            danger: orange
        }
    }
};