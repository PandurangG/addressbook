# addressbook

It has 5 API's and below is the description.
1) /user, POST mapping will allow us to create new user.
Sample payload ,
{
     
        "addressBook": [
            {
                "name": "Bob",
                "phoneNumber": "123123123"
            },
             {
                "name": "Mary",
                "phoneNumber": "56564544564"
            },
            {
                "name": "Jane",
                "phoneNumber": "14542312"
            }

        ]
    
}

2) /addressbook/{userId} GET mapping  which retrieves all the associated address books for that user.

3) /addressbook/{userId} , POST mapping which allow us to add new address book to existing user.

4) /user GET mapping which retrieves all users with their associated addressbooks in the response.

5) /unique/{userId1}/{userId2}, GET mapping which will give us the unique friend names among 2 users or addressBooks.


Postman collection is attached.


 
