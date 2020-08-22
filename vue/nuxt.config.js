export default {
  mode          : 'universal',
  target        : 'server',
  head          : {
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
  styleResources: {
    scss: [
      "./assets/kz-variable.scss"
    ]
  },
  css           : [],
  // serverMiddleware: ['~/middleware/serverMiddleware'],
  plugins       : [
    {
      src: "~/plugins/axios"
    },
    {
      src: '~/plugins/sessionStorage', ssr: false
    },
    {
      src: "~/plugins/text-field-outlined", ssr: true
    },
    "~/plugins/i18n",
    '~/plugins/fontawesome.js',
  ],
  axios         : {
    baseURL: "http://localhost:8765"
  },
  loading       : {
    continuous: true
  },
  components    : true,
  buildModules  : [
    '@nuxtjs/eslint-module',
    '@nuxtjs/style-resources',
    '@nuxtjs/tailwindcss',
    '@nuxtjs/vuetify'
  ],
  vuetify       : {
    optionsPath: "./vuetify.options.js"
  },
  modules       : [
    '@nuxtjs/axios',
  ],
  build         : {
    ssr: true,
    extend(config, ctx) {
      config.stats = 'errors-only'
      if (ctx.isDev) {
        config.devtool = ctx.isClient ? 'eval-source-map' : 'inline-source-map'
      }
    }
  },
  vue           : {
    config: {
      devtools: true
    }
  },
}
