# PokeDex

List activity todo's:
Search
Background Color
Pokemon Logo
Infinite Scroll
Pull down to refresh
Refactor: imageurl extraction
Refactor: passing pokemon object on intent

Pokemon detail activity todo's:
Pokemon Details (Photo, Name, ID, Pokemon Type, Abilities, Stats)
Pokemon type font color based on pokemon type
Different colors progressbar for stats
Cardview and Chipgroup design/layout

Objective:

Create a movie application that will display list of movies from the API. The list can be selected to view the detailed information. User can also search list of movies. The layout should have 3 bottom navigation Home, Search and Favorites.

Goal:

Retrieve data from the following API:

https://itunes.apple.com/search?term=star&country=au&media=movie

Architecture:

You may choose either MVVM or MVC.

Requirements:

Use Java

use RxJava

Retrofit

On the Home tab navigation, movie list items should be displayed the following details from the api:

Trackname

Artwork

Price

Genre

Star button for adding to favorites list from the home tab navigation of the list of movies

When selecting a movie, it should navigate to a Detailed screen displaying the following details:

Back button on the top left corner

Artwork 

Trackname

Release Date

Artist Name

Primary Genre Name

Track Price + Currency

Button showing "Add to favorite" if the movie is not on the favorites list yet or "Remove from favorite" if the movie has already been added to favorites list

Full description

When pressing back button on the detailed screen it should redirect back to the home tab navigation and display a date on the selected item of when it was last viewed

On the Search tab navigation, An empty screen displays when the search input is empty and when it's not empty it will display the search result on a list with the following details. Trackname, Artwork, Track Price + Currency, Genre, Short description. When selecting an item from the search result it should navigate to the detailed screen

On the Favorites tab navigation, it should show the list of all the movies added to favorites. when selecting an item from the favorites list, it should navigate to the detailed screen and the button should show "Remove from favorite"

Additional Clarification/Features:

Users can add movies to their favorites list from the list in the home tab navigation or detailed screen.

Movies in the favorites list can be added or  removed by:

Tapping the gold star icon on the home tab navigation of the List of movies.

Clicking the "Remove from Favorites" button on the detail screen.

Upon removal, the movie will be immediately excluded from the favorites screen.

After favoriting a movie on the detail screen, navigating back displays it as a favorite on the list in the home tab navigation. It can also unfavorite a movie from the List screen and navigating to the detail screen will show a add to favorite button

