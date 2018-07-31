###########################################################################
#                                  README
###########################################################################

# Automated tests for Wikipedia.org

# Project Structure:
    # Common automation code:
            # com.epam.automation
    # Selenium Driver and utilities:
            # com.epam.automation.driver
    # Page Object Pattern for Wikipedia.org web pages:
            # org.wikipedia.pages
    # Automated tests:
            # org.wikipedia.tests
    # Test data and resources:
            # src\test\java\resources

# To run the tests (chrome is the default browser, as specified in the config.properties)
mvn clean install

# To run the tests in a specific browser
mvn clean install -Dbrowser=chrome
mvn clean install -Dbrowser=firefox