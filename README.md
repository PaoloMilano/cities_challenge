# cities_challenge

This repo demonstrates my solution to a coding challenge I recently undertook. As part of this I tried using some of Android's new API's, such as ViewModel and DataBinding.

Below are the requirements that were set for this test. This had to be completed within 48 hours:


		 	 	 		
				
					
						
The goal of this assignment is to evaluate the problem solving skills, UX judgement and code quality.
						
We have a list of cities containing around 200k entries in JSON format. Each entry contains the following information:
						
{
     "country":"UA",			
    "name":"Hurzuf",
     "_id":707860,
     "coord":{			
          "lon":34.283333,				
          "lat":44.549999
     }					
}
						

Your task is to:											 								
●  Display this of cities on a scrollable list in alphabetic order (city first, country after)
											
    ○  "Denver, US" should appear before, "Sydney, Australia"
								
    ○  "Anaheim, US" should appear before "Denver, US"
			
●  Be able to filter the results by a given prefix string, over the city.
●  Selecting a city will show a map centered on the coordinates associated with the city.
●  Optimize for fast searches, loading time of the app is not so important
								
We define a prefix string as: a substring that matches the initial characters of the target string. For instance, assume the following entries:
Alabama, US
Albuquerque, US
								
Anaheim, US Arizona, US Sydney, AU
								
If the given prefix is 'A', all cities but Sydney should appear. Contrariwise, if the given prefix is “s”, the only result should be “Sydney, AU”.
If the given prefix is “Al”, “Alabama, US” and “Albuquerque, US” are the only results.
If the prefix given is “Alb” then the only result is “Albuquerque, US”
							
			
						
Additional requirements/restrictions:
						
	
●  The list will be provided to you as a plain text JSON format array.
●  The UI should be as responsive as possible while typing a filter.
●  The list should be updated with every character added/removed to the filter.
●  You can preprocess the list into any other representation that you consider more efficient for searches and display. Provide information of why that representation is more efficient in the comments of the code.		
●  Database implementations are forbidden
●  Provide unit tests, that your search algorithm is displaying the correct results giving different inputs, including invalid inputs.
●  Alpha/beta versions of the IDE are forbidden, you must work with the stable version of the IDE		
●  The code of the assignment has to be delivered along with the git repository (.git folder). We want to see the progress evolution
			

	
    ○  Language must be Java
    ○  UI has to be implemented using 1 activity with multiple fragments
    ○  Only 3rd party libraries allowed are: GSON or Jackson.
    ○  Compatible with Android 4.1+
		
				
								 							
						 					

