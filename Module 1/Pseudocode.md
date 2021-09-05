# Pet BAG - Check in

<details>
<summary>Required Functionality</summary>

1. Determine if the pet is a _dog_ or a _cat_ and check for boarding space
2. There are __30 spaces for dogs__ and __12 for cats__
    - Pet BAG will need to be able to adjust these counts
as the shop grows
3. If there is space for a new pet, collect the appropriate information
    - For returning pets, update the information as needed
4. Gather information on the length of the stay
5. Determine if the pet owner would like the pet to be groomed
    - __Only dogs can be groomed__ and only if they stay __two or more days__
6. Assign the pet to a space

</details>

<details>
<summary>Extra Information</summary>

| Type of Pet        | Daily Boarding Fee | Grooming Fee     |
| ------------------ | ------------------ | ---------------- |
| Dog &ge; 30lbs     | $34<sup>00</sup>   | $29<sup>95</sup> |
| Dog 20&mdash;30lbs | $29<sup>00</sup>   | $24<sup>95</sup> |
| Dog &lt; 20lbs     | $24<sup>00</sup>   | $19<sup>95</sup> |
| Cat                | $18<sup>00</sup>   |                  |

</details>

## Working Code (JavaScript)

```javascript
let Fees = {
    dog: {
        // Returns the boarding fee for dogs
            // Fees.dog.boarding(weight:number~Pounds) -> price:number~USD
        boarding(weight = null) {
            if(weight === null)
                throw 'No weight (in lbs) was given';

            if(weight >= 30)
                return 34;
            if(weight < 30 && weight > 20)
                return 29;
            return 24;
        },

        // Returns the grooming fee for dogs
            // Fees.dog.grooming(weight:number~Pounds) -> price:number~USD
        grooming(weight = null) {
            if(weight === null)
                throw 'No weight (in lbs) was given';

            if(weight >= 30)
                return 29.95;
            if(weight < 30 && weight > 20)
                return 24.95;
            return 19.95;
        },
    },

    cat: {
        boarding(weight = null) {
            return 18;
        },
    },
};

// Creates a new Pet
    // new Pet({ petType:string="dog"|"cat", petName:string?, petAge:number? })
class Pet {
    // 2. The available spaces
    static dogSpaces = 30;
    static catSpaces = 12;

    // The "database"
    static dogDatabase = new Map();
    static catDatabase = new Map();

    constructor(petType = 'dog') {
        petType = petType.toLowerCase();

        // 1. Check for boarding space...
        Check_for_boarding_space:
        switch(petType) {
            case 'dog':
            case 'cat': {
                if(Pet[`${ petType }Database`].size >= Pet[`${ petType }Spaces`])
                    throw `Unable to accommodate any more ${ petType }s at this time`;
            } break Check_for_boarding_space;

            default: {
                throw `Unable to provide services for "${ petType }" at tis time`;
            } break Check_for_boarding_space;
        }

        // 3. Collect meta-information...
        let petName = prompt(`Enter the ${ petType }'s name:`),
            petAge;

        // Check the "database" for the pet's name and information...
        let database = Pet[`${ petType }Database`],
            update, currentPet;

        let parseYesNo = answer => /^(y(?:es)?|t(?:rue)?)$/i.test(answer);

        // Create or update the pet in the "database"
        if(database.has(petName)) {
            currentPet = database.get(petName);

            // Ask to update the information
                // "Yes" => "yes" "y" "true" "t"
            update = parseYesNo(prompt(`Would you like to update ${ petName }'s information?`, 'yes'));
        }

        if(update || !database.has(petName))
            database.set(petName, currentPet = {
                petType, petName,
                petAge:  parseFloat(prompt(`What is ${ petName }'s age (in years)?`, currentPet?.petAge ?? 0)),
                [`${ petType }Weight`]: parseFloat(prompt(`What is ${ petName }'s weight (in pounds)?`, currentPet?.[`${ petType }Weight`] ?? 0)),
            });

        // 4. Get the duration information...
        let daysStay = parseFloat(prompt(`How long will ${ petName } be staying (in days)?`, 1));

        // 5. Get the grooming information (if applicable)
        let grooming =
            (!!~['dog'].indexOf(petType) && daysStay >= 2)?
                parseYesNo(prompt(`Will ${ petName } be receiving a groom during their stay?`, 'yes')):
            false;

        // 6. Assign the pet to a space...
            // The `spaceID` can use an array to move pets between different spaces...
        let spaceID = database.size,
            weight = currentPet[`${ petType }Weight`];

        // Extra functionality...
        let amountDue = Fees[petType].boarding(weight);

        if(grooming)
            amountDue += Fees[petType].grooming(weight);

        let paid = confirm(`Amount due: $${ amountDue } (USD)`);

        // If the owner is unable to pay, remove the pet...
        if(!paid) {
            database.delete(petName);

            return alert(`${ petName } has not been checked in: payment error`);
        }

        database.set(petName, currentPet = {
            ...currentPet,
            daysStay,
            grooming,
            [`${ [petType] }SpaceNumber`]: spaceID,
        });

        return currentPet;
    }
}
```
