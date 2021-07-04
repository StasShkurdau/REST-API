package com.example.Speedrun.REST.API;

import com.example.Speedrun.REST.API.model.Address;
import com.example.Speedrun.REST.API.model.Job;
import com.example.Speedrun.REST.API.model.Person;
import com.example.Speedrun.REST.API.model.PhoneNumber;
import com.example.Speedrun.REST.API.repository.AddressRepository;
import com.example.Speedrun.REST.API.repository.JobRepository;
import com.example.Speedrun.REST.API.repository.PersonRepository;
import com.example.Speedrun.REST.API.repository.PhoneNumberRepository;


public class AutoFillingOfDB {


    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private final PhoneNumberRepository phoneNumberRepository;
    private final JobRepository jobRepository;

    public AutoFillingOfDB(AddressRepository addressRepository, PersonRepository personRepository, PhoneNumberRepository phoneNumberRepository, JobRepository jobRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
        this.phoneNumberRepository = phoneNumberRepository;
        this.jobRepository = jobRepository;
    }

    public void fillDB(){
        for(int i = 0; i < 600; i++){
            Person newPerson = new Person();

            Address address = new Address();
            address.setAddress(generateAddress().toString());
            addressRepository.save(address);
            newPerson.setAddress(address);

            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setPhoneNumber(generatePhoneNumber().toString());
            phoneNumberRepository.save(phoneNumber);
            newPerson.addPhoneNumber(phoneNumber);

            Job job = new Job();
            job.setJob(generateJob().toString());
            jobRepository.save(job);
            newPerson.setJob(job);

            newPerson.setName(generateName().toString());

            personRepository.save(newPerson);

        }
    }
    public StringBuilder generatePhoneNumber(){
        StringBuilder number = new StringBuilder();
        String[] pref = {"33", "44", "29"};
        number.append("+375");
        number.append(pref[(int)(Math.random()*3)]);
        for(int i = 0; i < 7; i++) {
            number.append((int) (Math.random() * 9));
        }
        return number;
    }

    public StringBuilder generateName() {
        StringBuilder name = new StringBuilder();
        String[] firstName = {"Ivan", "Petr", "Gans", "Shults", "Lexa", "Slava", "Danila", "Joahim", "Alena", "Oksana", "Frideric", "Paul"};
        String[] lastName = {"Rubicov", "Ivanov", "Thymyanov", "Pusikov", "Koval", "Kovalev", "Peskof", "Vanilov"};
        name.append(firstName[(int)(Math.random()*11)]);
        name.append(" ");
        name.append(lastName[(int)(Math.random()*7)]);
        return  name;
    }

    public StringBuilder generateAddress() {
        StringBuilder address = new StringBuilder();
        address.append(generateRandomWord());
        address.append((int) (Math.random()*50));
        return address;
    }

    public StringBuilder generateJob() {
        StringBuilder job = new StringBuilder();
        job.append("company: ");
        job.append(generateRandomWord());
        return job;
    }

    public StringBuffer generateRandomWord()
    {
        StringBuffer randomString = new StringBuffer();
        int count =(int) (Math.random()*8)+4;
        for(int i = 0; i < count; i++){
            randomString.append( (char) (Math.random() * 27) );
        }
        return randomString;
    }
}
