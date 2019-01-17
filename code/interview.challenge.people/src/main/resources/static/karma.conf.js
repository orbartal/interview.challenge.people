//jshint strict: false
module.exports = function(config) {
  config.set({

    basePath: '.',

    files: [
      './app/lib/angular/angular.js',
      './app/lib/angular-route/angular-route.js',
      './node_modules/angular-mocks/angular-mocks.js',
      './app/*.js',
      './app/services/*.js',
      './app/pages/page1/*.js'
    ],

    autoWatch: true,

    frameworks: ['jasmine'],

    browsers: ['Chrome'],

    plugins: [
      'karma-chrome-launcher',
      'karma-firefox-launcher',
      'karma-jasmine'
    ]


  });
};
