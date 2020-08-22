import Vue from 'vue';

const VTextField = Vue.options.components["VTextField"];

Vue.component('TextFieldOutlined', {
  extends: VTextField,

  props: {
    appendOuterIcon : String,
    autofocus       : Boolean,
    clearable       : Boolean,
    clearIcon       : {
      type   : String,
      default: '$clear'
    },
    dense           : {
      default: true
    },
    counter         : [Boolean, Number, String],
    counterValue    : Function,
    filled          : Boolean,
    flat            : Boolean,
    fullWidth       : Boolean,
    label           : String,
    placeholder     : String,
    prefix          : String,
    prependInnerIcon: String,
    reverse         : Boolean,
    rounded         : Boolean,
    shaped          : Boolean,
    singleLine      : Boolean,
    solo            : Boolean,
    soloInverted    : Boolean,
    suffix          : String,
    type            : {
      type   : String,
      default: 'text'
    },
    outlined        : {
      type   : Boolean,
      default: true
    },
  }
})
