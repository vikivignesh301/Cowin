Feature: COWIN WEBSITE FOR VACCINATION
Scenario: Search For State and District
Given user Launch The Url
When enter The State and District
Then click the Search button

Scenario: Enter The Vaccine Details
When click On Details Of Vaccine
And validate The Details Of Vaccine
And print The Total No Of Center Displayed
Then validate With Screenshot

