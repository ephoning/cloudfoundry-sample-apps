Minimalistic Python Web Application
===================================
A tiny web application (using Flask; see: http://flask.pocoo.org) that shows the envrionment variables in effect for this application.

It can be used to perform minimal testing of a Cloud Foundry Python buildpack (.e.g., https://github.com/ephoning/heroku-buildpack-python, a Heroku Python buildpack modified for use on Cloud Foundry)

Note that when pushed to Cloud Foundry, and browsing to its URL, the various Cloud Foundry environment variables show up: VCAP_SERVICES, VCAP_APPLICATION, etc.
