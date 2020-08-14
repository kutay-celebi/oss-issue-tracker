const {VuetifyLoaderPlugin} = require('vuetify-loader')

export default {
  mode            : 'spa',
  target          : 'server',
  head            : {
    title: process.env.npm_package_name || '',
    meta : [
      {charset: 'utf-8'},
      {name: 'viewport', content: 'width=device-width, initial-scale=1'},
      {hid: 'description', name: 'description', content: process.env.npm_package_description || ''}
    ],
    link : [
      {rel: 'icon', type: 'image/x-icon', href: '/favicon.ico'}
    ]
  },
  serverMiddleware: ['~/middleware/serverMiddleware'],
  plugins         : [
    {src: "~/plugins/axios", ssr: true},
    "~/plugins/i18n",
    '~/plugins/fontawesome.js',
    '~/plugins/sessionStorage',
  ],
  components      : true,
  buildModules    : [
    '@nuxtjs/eslint-module',
    '@nuxtjs/tailwindcss',
    '@nuxtjs/vuetify'
  ],
  modules         : [
    '@nuxtjs/axios',
    'nuxt-sass-resources-loader'
  ],
  sassResources   : [
    '~/assets/variable.scss'
  ],
  css             : [],
  build           : {
    extend(config, ctx) {
      if (ctx.isDev) {
        config.devtool = ctx.isClient ? 'eval-source-map' : 'inline-source-map'
      }
    }

  },
  vue             : {
    config: {
      devtools: true
    }
  },
  axios           : {
    baseURL: "http://localhost:8765"
  },

  vuetify: {
    customProperties: true,
    customVariables : ['~/assets/variable.scss'],
    theme           : {
      dark  : false,
      themes: {
        light: {
          primary  : '#3f51b5',
          secondary: '#b0bec5',
          accent   : '#8c9eff',
          error    : '#b71c1c',
        },
        dark : {
          secondary: "#E1E2E2",
        },
      }
    }
  },
}
