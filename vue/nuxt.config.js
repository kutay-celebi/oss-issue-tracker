export default {
  mode        : 'spa',
  target      : 'server',
  head        : {
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
  css         : [],
  // serverMiddleware: ['~/middleware/serverMiddleware'],
  plugins     : [
    {
      src: "~/plugins/axios", ssr: true
    },
    "~/plugins/i18n",
    '~/plugins/fontawesome.js',
    '~/plugins/sessionStorage',
  ],
  components  : true,
  buildModules: [
    '@nuxtjs/eslint-module',
    '@nuxtjs/tailwindcss',
    '@nuxtjs/vuetify'
  ],
  vuetify     : {
    optionsPath: "./vuetify.options.js"
  },
  modules     : [
    '@nuxtjs/axios',
  ],
  build       : {
    extend(config, ctx) {
      if (ctx.isDev) {
        config.devtool = ctx.isClient ? 'eval-source-map' : 'inline-source-map'
      }
    }
  },
  vue         : {
    config: {
      devtools: true
    }
  },
}
