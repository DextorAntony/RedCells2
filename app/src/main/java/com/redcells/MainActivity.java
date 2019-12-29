package com.redcells;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mFirebaseDatabase;

    @Override
    public void onBackPressed() {
        finish();
        finishAffinity();
        super.onBackPressed();
    }

    private final String[] language ={"Adilabad","Agra","Ahmedabad","Ahmednagar","Aizawl","Ajitgarh","(Mohali)","Ajmer","Akola","Alappuzha","Aligarh","Alirajpur","Allahabad","Almora","Alwar","Ambala","Ambedkar","Nagar","Amravati","Amreli","district","Amritsar","Anand","Anantapur","Anantnag","Angul","Anjaw","Anuppur","Araria","Ariyalur","Arwal","Ashok","Nagar","Auraiya","Aurangabad","Aurangabad","Azamgarh","Badgam","Bagalkot","Bageshwar","Bagpat","Bahraich","Baksa","Balaghat","Balangir","Balasore","Ballia","Balrampur","Banaskantha","Banda","Bandipora","Bangalore","Rural","Bangalore","Urban","Banka","Bankura","Banswara","Barabanki","Baramulla","Baran","Bardhaman","Bareilly","Bargarh","(Baragarh)","Barmer","Barnala","Barpeta","Barwani","Bastar","Basti","Bathinda","Beed","Begusarai","Belgaum","Bellary","Betul","Bhadrak","Bhagalpur","Bhandara","Bharatpur","Bharuch","Bhavnagar","Bhilwara","Bhind","Bhiwani","Bhojpur","Bhopal","Bidar","Bijapur","Bijapur","Bijnor","Bikaner","Bilaspur","Bilaspur","Birbhum","Bishnupur","Bokaro","Bongaigaon","Boudh","(Bauda)","Budaun","Bulandshahr","Buldhana","Bundi","Burhanpur","Buxar","Cachar","Central","Delhi","Chamarajnagar","Chamba","Chamoli","Champawat","Champhai","Chandauli","Chandel","Chandigarh","Chandrapur","Changlang","Chatra","Chennai","Chhatarpur","Chhatrapati","Shahuji","Maharaj","Nagar","Chhindwara","Chikkaballapur","Chikkamagaluru","Chirang","Chitradurga","Chitrakoot","Chittoor","Chittorgarh","Churachandpur","Churu","Coimbatore","Cooch","Behar","Cuddalore","Cuttack","Dadra","and","Nagar","Haveli","Dahod","Dakshin","Dinajpur","Dakshina","Kannada","Daman","Damoh","Dantewada","Darbhanga","Darjeeling","Darrang","Datia","Dausa","Davanagere","Debagarh","(Deogarh)","Dehradun","Deoghar","Deoria","Dewas","Dhalai","Dhamtari","Dhanbad","Dhar","Dharmapuri","Dharwad","Dhemaji","Dhenkanal","Dholpur","Dhubri","Dhule","Dibang","Valley","Dibrugarh","Dima","Hasao","Dimapur","Dindigul","Dindori","Diu","Doda","Dumka","Dungapur","Durg","East","Champaran","East","Delhi","East","Garo","Hills","East","Khasi","Hills","East","Siang","East","Sikkim","East","Singhbhum","Eluru","Ernakulam","Erode","Etah","Etawah","Faizabad","Faridabad","Faridkot","Farrukhabad","Fatehabad","Fatehgarh","Sahib","Fatehpur","Fazilka","Firozabad","Firozpur","Gadag","Gadchiroli","Gajapati","Ganderbal","Gandhinagar","Ganganagar","Ganjam","Garhwa","Gautam","Buddh","Nagar","Gaya","Ghaziabad","Ghazipur","Giridih","Goalpara","Godda","Golaghat","Gonda","Gondia","Gopalganj","Gorakhpur","Gulbarga","Gumla","Guna","Guntur","Gurdaspur","Gurgaon","Gwalior","Hailakandi","Hamirpur","Hamirpur","Hanumangarh","Harda","Hardoi","Haridwar","Hassan","Haveri","district","Hazaribag","Hingoli","Hissar","Hooghly","Hoshangabad","Hoshiarpur","Howrah","Hyderabad","Hyderabad","Idukki","Imphal","East","Imphal","West","Indore","Jabalpur","Jagatsinghpur","Jaintia","Hills","Jaipur","Jaisalmer","Jajpur","Jalandhar","Jalaun","Jalgaon","Jalna","Jalore","Jalpaiguri","Jammu","Jamnagar","Jamtara","Jamui","Janjgir-Champa","Jashpur","Jaunpur","district","Jehanabad","Jhabua","Jhajjar","Jhalawar","Jhansi","Jharsuguda","Jhunjhunu","Jind","Jodhpur","Jorhat","Junagadh","Jyotiba","Phule","Nagar","Kabirdham","(formerly","Kawardha)","Kadapa","Kaimur","Kaithal","Kakinada","Kalahandi","Kamrup","Kamrup","Metropolitan","Kanchipuram","Kandhamal","Kangra","Kanker","Kannauj","Kannur","Kanpur","Kanshi","Ram","Nagar","Kanyakumari","Kapurthala","Karaikal","Karauli","Karbi","Anglong","Kargil","Karimganj","Karimnagar","Karnal","Karur","Kasaragod","Kathua","Katihar","Katni","Kaushambi","Kendrapara","Kendujhar","(Keonjhar)","Khagaria","Khammam","Khandwa","(East","Nimar)","Khargone","(West","Nimar)","Kheda","Khordha","Khowai","Khunti","Kinnaur","Kishanganj","Kishtwar","Kodagu","Koderma","Kohima","Kokrajhar","Kolar","Kolasib","Kolhapur","Kolkata","Kollam","Koppal","Koraput","Korba","Koriya","Kota","Kottayam","Kozhikode","Krishna","Kulgam","Kullu","Kupwara","Kurnool","Kurukshetra","Kurung","Kumey","Kushinagar","Kutch","Lahaul","and","Spiti","Lakhimpur","Lakhimpur","Kheri","Lakhisarai","Lalitpur","Latehar","Latur","Lawngtlai","Leh","Lohardaga","Lohit","Lower","Dibang","Valley","Lower","Subansiri","Lucknow","Ludhiana","Lunglei","Madhepura","Madhubani","Madurai","Mahamaya","Nagar","Maharajganj","Mahasamund","Mahbubnagar","Mahe","Mahendragarh","Mahoba","Mainpuri","Malappuram","Maldah","Malkangiri","Mamit","Mandi","Mandla","Mandsaur","Mandya","Mansa","Marigaon","Mathura","Mau","Mayurbhanj","Medak","Meerut","Mehsana","Mewat","Mirzapur","Moga","Mokokchung","Mon","Moradabad","Morena","Mumbai","City","Mumbai","suburban","Munger","Murshidabad","Muzaffarnagar","Muzaffarpur","Mysore","Nabarangpur","Nadia","Nagaon","Nagapattinam","Nagaur","Nagpur","Nainital","Nalanda","Nalbari","Nalgonda","Namakkal","Nanded","Nandurbar","Narayanpur","Narmada","Narsinghpur","Nashik","Navsari","Nawada","Nawanshahr","Nayagarh","Neemuch","Nellore","New","Delhi","Nilgiris","Nizamabad","North","24","Parganas","North","Delhi","North","East","Delhi","North","Goa","North","Sikkim","North","Tripura","North","West","Delhi","Nuapada","Ongole","Osmanabad","Pakur","Palakkad","Palamu","Pali","Palwal","Panchkula","Panchmahal","Panchsheel","Nagar","district","(Hapur)","Panipat","Panna","Papum","Pare","Parbhani","Paschim","Medinipur","Patan","Pathanamthitta","Pathankot","Patiala","Patna","Pauri","Garhwal","Perambalur","Phek","Pilibhit","Pithoragarh","Pondicherry","Poonch","Porbandar","Pratapgarh","Pratapgarh","Pudukkottai","Pulwama","Pune","Purba","Medinipur","Puri","Purnia","Purulia","Raebareli","Raichur","Raigad","Raigarh","Raipur","Raisen","Rajauri","Rajgarh","Rajkot","Rajnandgaon","Rajsamand","Ramabai","Nagar","(Kanpur","Dehat)","Ramanagara","Ramanathapuram","Ramban","Ramgarh","Rampur","Ranchi","Ratlam","Ratnagiri","Rayagada","Reasi","Rewa","Rewari","Ri","Bhoi","Rohtak","Rohtas","Rudraprayag","Rupnagar","Sabarkantha","Sagar","Saharanpur","Saharsa","Sahibganj","Saiha","Salem","Samastipur","Samba","Sambalpur","Sangli","Sangrur","Sant","Kabir","Nagar","Sant","Ravidas","Nagar","Saran","Satara","Satna","Sawai","Madhopur","Sehore","Senapati","Seoni","Seraikela","Kharsawan","Serchhip","Shahdol","Shahjahanpur","Shajapur","Shamli","Sheikhpura","Sheohar","Sheopur","Shimla","Shimoga","Shivpuri","Shopian","Shravasti","Sibsagar","Siddharthnagar","Sidhi","Sikar","Simdega","Sindhudurg","Singrauli","Sirmaur","Sirohi","Sirsa","Sitamarhi","Sitapur","Sivaganga","Siwan","Solan","Solapur","Sonbhadra","Sonipat","Sonitpur","South","24","Parganas","South","Delhi","South","Garo","Hills","South","Goa","South","Sikkim","South","Tripura","South","West","Delhi","Sri","Muktsar","Sahib","Srikakulam","Srinagar","Subarnapur","(Sonepur)","Sultanpur","Sundergarh","Supaul","Surat","Surendranagar","Surguja","Tamenglong","Tarn","Taran","Tawang","Tehri","Garhwal","Thane","Thanjavur","The","Dangs","Theni","Thiruvananthapuram","Thoothukudi","Thoubal","Thrissur","Tikamgarh","Tinsukia","Tirap","Tiruchirappalli","Tirunelveli","Tirupur","Tiruvallur","Tiruvannamalai","Tiruvarur","Tonk","Tuensang","Tumkur","Udaipur","Udalguri","Udham","Singh","Nagar","Udhampur","Udupi","Ujjain","Ukhrul","Umaria","Una","Unnao","Upper","Siang","Upper","Subansiri","Uttar","Dinajpur","Uttara","Kannada","Uttarkashi","Vadodara","Vaishali","Valsad","Varanasi","Vellore","Vidisha","Viluppuram","Virudhunagar","Visakhapatnam","Vizianagaram","Vyara","Warangal","Wardha","Washim","Wayanad","West","Champaran","West","Delhi","West","Garo","Hills","West","Kameng","West","Khasi","Hills","West","Siang","West","Sikkim","West","Singhbhum","West","Tripura","Wokha","Yadgir","Yamuna","Nagar","Yanam","Yavatmal","Zunheboto"
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase mFirebaseInstance = FirebaseDatabase.getInstance();

        mFirebaseDatabase = mFirebaseInstance.getReference();
        final EditText name = findViewById(R.id.editText);
        final EditText mobile = findViewById(R.id.editText3);
        Button newb = findViewById(R.id.button2);
        final Spinner blood = findViewById(R.id.spinner);






        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.select_dialog_item, language);

        final AutoCompleteTextView actv = findViewById(R.id.textView18);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setTextColor(Color.RED);
//        FirebaseUser user = mAuth.getCurrentUser();
//        userID = user.getUid();
//        String userID = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        newb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String location = actv.getText().toString();

                String name1 = name.getText().toString();
                String mobile1 = mobile.getText().toString();
                String blood1 = blood.getSelectedItem().toString();
                String combo = name1 + "," + mobile1 + "," + location ;

                if (blood1.equals("") || mobile1.equals("") || location.equals("") || mobile1.length()<10) {

                    Toast.makeText(MainActivity.this, "Please fill all the details.", Toast.LENGTH_SHORT).show();
                }

                else {
                    mFirebaseDatabase.child("users").child(blood1).child(mobile1).setValue(combo);


                    Toast.makeText(MainActivity.this, "Donor Added", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(MainActivity.this, Home.class);
                    startActivity(home);
                    finish();
                }


            }

        });


    }

}



