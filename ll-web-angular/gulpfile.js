// Main build file that manages a simple AngularJS application, used to demonstrate accessing data from a simple
// Spring REST application.
//
// The tasks "clean-run" will clean your distribution directory and run the http server there.  Once it finishes
// executing, you should see the message "Server started http://localhost:8000" at your terminal prompt.
//

// Include gulp
var gulp = require('gulp'); 

// Include Our Plugins
var jshint     = require('gulp-jshint');
var concat     = require('gulp-concat');
var uglify     = require('gulp-uglify');
var rename     = require('gulp-rename');
var connect    = require('gulp-connect');
var minifyCss  = require('gulp-minify-css');
var ngAnnotate = require('gulp-ng-annotate');
var del        = require('del');
var q          = require('Q');

var appPaths = {
  dist:             './dist', 
  distJS:           'dist/js',
  distCSS:          'dist/css',
  distFonts:        'dist/fonts',
  distImages:       'dist/images',
  distHtmlPartials: 'dist/partials',
  distHtmlDirectives: 'dist/directives',
  appJS:            'app/js/app.js',
  allAppJS:         'app/**/*.js',
  allAppCSS:        'app/**/*.css',
  allAppHtml:       'app/**/*.html',
  srcJS:            'app/js/**/*.js',
  srcCSS:           'app/css/**/*.css',
  srcImages:        'app/images/**/*.*',
  srcFonts:         'app/fonts/**/*.*',
  srcRootContent:   'app/*.*',
  srcHtmlPartials:  'app/partials/**/*.html',
  srcHtmlDirectives:  'app/directives/**/*.html',
  srcBowerJS:       'bower_components/**/*.js',
  srcBowerCSS:      'bower_components/**/*.css'
};

//--------------------------------------------------------------------------------------------------------------------
// Lint Task
gulp.task('lint', function() {
    return gulp.src('app/js/*.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

//--------------------------------------------------------------------------------------------------------------------
// Concatenate and move JS to dist folder
gulp.task('app-js', function() {
    return gulp.src(['app/js/app.js', appPaths.allAppJS])
        .pipe(concat('app.js'))
        .pipe(ngAnnotate())
        .pipe(uglify())
        .pipe(gulp.dest(appPaths.distJS))
});

//--------------------------------------------------------------------------------------------------------------------
// Concatenate and move CSS files over
gulp.task('app-css', function() {
    return gulp.src([appPaths.srcCSS])
      .pipe(concat('app.css'))
      .pipe(minifyCss())
      .pipe(gulp.dest(appPaths.distCSS));
});

//--------------------------------------------------------------------------------------------------------------------
// Copy 3rd party JS files
gulp.task('ref-js', function() {
    return gulp.src([
      'bower_components/jquery/dist/jquery.js',
      'bower_components/angular/angular.js',
      'bower_components/angular-route/angular-route.js',
      'bower_components/angular-resource/angular-resource.js',
      'bower_components/bootstrap/dist/js/bootstrap.js',    
      '!js/**/*.min.js',
      
      ])
        .pipe(concat('ref.js'))
        .pipe(uglify())
        .pipe(gulp.dest(appPaths.distJS));
});

//--------------------------------------------------------------------------------------------------------------------
// Copy 3rd party CSS files
gulp.task('ref-css', function() {
    return gulp.src([
      'bower_components/bootstrap/dist/css/bootstrap.css',
      'bower_components/bootstrap/dist/css/bootstrap-theme.css',
      'bower_components/bootstrap/dist/css/bootstrap-theme.css'
      ])
        .pipe(concat('ref.css'))
        .pipe(minifyCss())
        .pipe(gulp.dest(appPaths.distCSS));
});

//--------------------------------------------------------------------------------------------------------------------
// Move partials over
gulp.task('html-partials', ['html-directives'], function() {
    return gulp.src([appPaths.srcHtmlPartials])
      .pipe(gulp.dest(appPaths.distHtmlPartials));
});

//--------------------------------------------------------------------------------------------------------------------
// Move partials over
gulp.task('html-directives', function() {
    return gulp.src([appPaths.srcHtmlDirectives])
      .pipe(gulp.dest(appPaths.distHtmlDirectives));
});


//--------------------------------------------------------------------------------------------------------------------
// Move images over
gulp.task('html-images', ['html-fonts'], function() {
    return gulp.src([appPaths.srcImages])
      .pipe(gulp.dest(appPaths.distImages));
});

//--------------------------------------------------------------------------------------------------------------------
// Move fonts over
gulp.task('html-fonts', function() {
    return gulp.src([appPaths.srcFonts])
      .pipe(gulp.dest(appPaths.distFonts));
});

//--------------------------------------------------------------------------------------------------------------------
// Move root content over
gulp.task('root-content', function() {
    return gulp.src([appPaths.srcRootContent])
      .pipe(gulp.dest(appPaths.dist));
});

//--------------------------------------------------------------------------------------------------------------------
// Watch Files For Changes
gulp.task('watch', function() {
    gulp.watch(appPaths.allAppJS, ['app-js']);
    gulp.watch(appPaths.allAppCSS, ['app-css']);
    gulp.watch(appPaths.allAppHtml, ['html-partials']);
});

//--------------------------------------------------------------------------------------------------------------------
// Run Web server
gulp.task('webserver', function() {
  connect.server({
      port: 8000,
      root: 'dist/'
  });
});

//--------------------------------------------------------------------------------------------------------------------
// Clean dist folder
gulp.task('clean', function() {
   var deferred = q.defer();
   del(appPaths.dist, function() {
       deferred.resolve();
   }); 
   return deferred.promise;
});

//--------------------------------------------------------------------------------------------------------------------
gulp.task('clean-run', ['clean'], function() {
   gulp.start('run');
});

//--------------------------------------------------------------------------------------------------------------------
gulp.task('run', ['app-js', 'app-css', 'ref-js', 'ref-css', 'html-images', 'html-partials', 'root-content'], function() {
   gulp.start( /*'lint',*/ 'watch', 'webserver'); 
});


//--------------------------------------------------------------------------------------------------------------------
// Default Task
gulp.task('default', ['run']);