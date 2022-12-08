Feature: Bookmark Test

	Scenario: search job vacancy
		Given User on the browser "https://kerja.kitalulus.com/id"
		When User search job vacancy "Quality Assurance"
		And User click one of the search job
		And User bookmark a job
		Then The mark job already saved