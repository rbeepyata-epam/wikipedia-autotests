###########################################################################
#                                  README
###########################################################################

# Automated tests for Wikipedia.org


#Page Object Pattern implemented for the Wikipedia.org web pages
#

# To run the tests (chrome is the default browser, as specified in the config.properties)
mvn clean install

###########################################################################
# To run the tests in a specific browser
mvn clean install -Dbrowser=chrome
mvn clean install -Dbrowser=firefox