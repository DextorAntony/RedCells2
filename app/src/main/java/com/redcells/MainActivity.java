package com.redcells;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.LocationRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mFirebaseDatabase;
    private ImageButton u;
    private TextView b,dob;
    private EditText age;
    String[] language ={"Adilabad","Agra","Ahmedabad","Ahmednagar","Aizawl","Ajitgarh","(Mohali)","Ajmer","Akola","Alappuzha","Aligarh","Alirajpur","Allahabad","Almora","Alwar","Ambala","Ambedkar","Nagar","Amravati","Amreli","district","Amritsar","Anand","Anantapur","Anantnag","Angul","Anjaw","Anuppur","Araria","Ariyalur","Arwal","Ashok","Nagar","Auraiya","Aurangabad","Aurangabad","Azamgarh","Badgam","Bagalkot","Bageshwar","Bagpat","Bahraich","Baksa","Balaghat","Balangir","Balasore","Ballia","Balrampur","Banaskantha","Banda","Bandipora","Bangalore","Rural","Bangalore","Urban","Banka","Bankura","Banswara","Barabanki","Baramulla","Baran","Bardhaman","Bareilly","Bargarh","(Baragarh)","Barmer","Barnala","Barpeta","Barwani","Bastar","Basti","Bathinda","Beed","Begusarai","Belgaum","Bellary","Betul","Bhadrak","Bhagalpur","Bhandara","Bharatpur","Bharuch","Bhavnagar","Bhilwara","Bhind","Bhiwani","Bhojpur","Bhopal","Bidar","Bijapur","Bijapur","Bijnor","Bikaner","Bilaspur","Bilaspur","Birbhum","Bishnupur","Bokaro","Bongaigaon","Boudh","(Bauda)","Budaun","Bulandshahr","Buldhana","Bundi","Burhanpur","Buxar","Cachar","Central","Delhi","Chamarajnagar","Chamba","Chamoli","Champawat","Champhai","Chandauli","Chandel","Chandigarh","Chandrapur","Changlang","Chatra","Chennai","Chhatarpur","Chhatrapati","Shahuji","Maharaj","Nagar","Chhindwara","Chikkaballapur","Chikkamagaluru","Chirang","Chitradurga","Chitrakoot","Chittoor","Chittorgarh","Churachandpur","Churu","Coimbatore","Cooch","Behar","Cuddalore","Cuttack","Dadra","and","Nagar","Haveli","Dahod","Dakshin","Dinajpur","Dakshina","Kannada","Daman","Damoh","Dantewada","Darbhanga","Darjeeling","Darrang","Datia","Dausa","Davanagere","Debagarh","(Deogarh)","Dehradun","Deoghar","Deoria","Dewas","Dhalai","Dhamtari","Dhanbad","Dhar","Dharmapuri","Dharwad","Dhemaji","Dhenkanal","Dholpur","Dhubri","Dhule","Dibang","Valley","Dibrugarh","Dima","Hasao","Dimapur","Dindigul","Dindori","Diu","Doda","Dumka","Dungapur","Durg","East","Champaran","East","Delhi","East","Garo","Hills","East","Khasi","Hills","East","Siang","East","Sikkim","East","Singhbhum","Eluru","Ernakulam","Erode","Etah","Etawah","Faizabad","Faridabad","Faridkot","Farrukhabad","Fatehabad","Fatehgarh","Sahib","Fatehpur","Fazilka","Firozabad","Firozpur","Gadag","Gadchiroli","Gajapati","Ganderbal","Gandhinagar","Ganganagar","Ganjam","Garhwa","Gautam","Buddh","Nagar","Gaya","Ghaziabad","Ghazipur","Giridih","Goalpara","Godda","Golaghat","Gonda","Gondia","Gopalganj","Gorakhpur","Gulbarga","Gumla","Guna","Guntur","Gurdaspur","Gurgaon","Gwalior","Hailakandi","Hamirpur","Hamirpur","Hanumangarh","Harda","Hardoi","Haridwar","Hassan","Haveri","district","Hazaribag","Hingoli","Hissar","Hooghly","Hoshangabad","Hoshiarpur","Howrah","Hyderabad","Hyderabad","Idukki","Imphal","East","Imphal","West","Indore","Jabalpur","Jagatsinghpur","Jaintia","Hills","Jaipur","Jaisalmer","Jajpur","Jalandhar","Jalaun","Jalgaon","Jalna","Jalore","Jalpaiguri","Jammu","Jamnagar","Jamtara","Jamui","Janjgir-Champa","Jashpur","Jaunpur","district","Jehanabad","Jhabua","Jhajjar","Jhalawar","Jhansi","Jharsuguda","Jhunjhunu","Jind","Jodhpur","Jorhat","Junagadh","Jyotiba","Phule","Nagar","Kabirdham","(formerly","Kawardha)","Kadapa","Kaimur","Kaithal","Kakinada","Kalahandi","Kamrup","Kamrup","Metropolitan","Kanchipuram","Kandhamal","Kangra","Kanker","Kannauj","Kannur","Kanpur","Kanshi","Ram","Nagar","Kanyakumari","Kapurthala","Karaikal","Karauli","Karbi","Anglong","Kargil","Karimganj","Karimnagar","Karnal","Karur","Kasaragod","Kathua","Katihar","Katni","Kaushambi","Kendrapara","Kendujhar","(Keonjhar)","Khagaria","Khammam","Khandwa","(East","Nimar)","Khargone","(West","Nimar)","Kheda","Khordha","Khowai","Khunti","Kinnaur","Kishanganj","Kishtwar","Kodagu","Koderma","Kohima","Kokrajhar","Kolar","Kolasib","Kolhapur","Kolkata","Kollam","Koppal","Koraput","Korba","Koriya","Kota","Kottayam","Kozhikode","Krishna","Kulgam","Kullu","Kupwara","Kurnool","Kurukshetra","Kurung","Kumey","Kushinagar","Kutch","Lahaul","and","Spiti","Lakhimpur","Lakhimpur","Kheri","Lakhisarai","Lalitpur","Latehar","Latur","Lawngtlai","Leh","Lohardaga","Lohit","Lower","Dibang","Valley","Lower","Subansiri","Lucknow","Ludhiana","Lunglei","Madhepura","Madhubani","Madurai","Mahamaya","Nagar","Maharajganj","Mahasamund","Mahbubnagar","Mahe","Mahendragarh","Mahoba","Mainpuri","Malappuram","Maldah","Malkangiri","Mamit","Mandi","Mandla","Mandsaur","Mandya","Mansa","Marigaon","Mathura","Mau","Mayurbhanj","Medak","Meerut","Mehsana","Mewat","Mirzapur","Moga","Mokokchung","Mon","Moradabad","Morena","Mumbai","City","Mumbai","suburban","Munger","Murshidabad","Muzaffarnagar","Muzaffarpur","Mysore","Nabarangpur","Nadia","Nagaon","Nagapattinam","Nagaur","Nagpur","Nainital","Nalanda","Nalbari","Nalgonda","Namakkal","Nanded","Nandurbar","Narayanpur","Narmada","Narsinghpur","Nashik","Navsari","Nawada","Nawanshahr","Nayagarh","Neemuch","Nellore","New","Delhi","Nilgiris","Nizamabad","North","24","Parganas","North","Delhi","North","East","Delhi","North","Goa","North","Sikkim","North","Tripura","North","West","Delhi","Nuapada","Ongole","Osmanabad","Pakur","Palakkad","Palamu","Pali","Palwal","Panchkula","Panchmahal","Panchsheel","Nagar","district","(Hapur)","Panipat","Panna","Papum","Pare","Parbhani","Paschim","Medinipur","Patan","Pathanamthitta","Pathankot","Patiala","Patna","Pauri","Garhwal","Perambalur","Phek","Pilibhit","Pithoragarh","Pondicherry","Poonch","Porbandar","Pratapgarh","Pratapgarh","Pudukkottai","Pulwama","Pune","Purba","Medinipur","Puri","Purnia","Purulia","Raebareli","Raichur","Raigad","Raigarh","Raipur","Raisen","Rajauri","Rajgarh","Rajkot","Rajnandgaon","Rajsamand","Ramabai","Nagar","(Kanpur","Dehat)","Ramanagara","Ramanathapuram","Ramban","Ramgarh","Rampur","Ranchi","Ratlam","Ratnagiri","Rayagada","Reasi","Rewa","Rewari","Ri","Bhoi","Rohtak","Rohtas","Rudraprayag","Rupnagar","Sabarkantha","Sagar","Saharanpur","Saharsa","Sahibganj","Saiha","Salem","Samastipur","Samba","Sambalpur","Sangli","Sangrur","Sant","Kabir","Nagar","Sant","Ravidas","Nagar","Saran","Satara","Satna","Sawai","Madhopur","Sehore","Senapati","Seoni","Seraikela","Kharsawan","Serchhip","Shahdol","Shahjahanpur","Shajapur","Shamli","Sheikhpura","Sheohar","Sheopur","Shimla","Shimoga","Shivpuri","Shopian","Shravasti","Sibsagar","Siddharthnagar","Sidhi","Sikar","Simdega","Sindhudurg","Singrauli","Sirmaur","Sirohi","Sirsa","Sitamarhi","Sitapur","Sivaganga","Siwan","Solan","Solapur","Sonbhadra","Sonipat","Sonitpur","South","24","Parganas","South","Delhi","South","Garo","Hills","South","Goa","South","Sikkim","South","Tripura","South","West","Delhi","Sri","Muktsar","Sahib","Srikakulam","Srinagar","Subarnapur","(Sonepur)","Sultanpur","Sundergarh","Supaul","Surat","Surendranagar","Surguja","Tamenglong","Tarn","Taran","Tawang","Tehri","Garhwal","Thane","Thanjavur","The","Dangs","Theni","Thiruvananthapuram","Thoothukudi","Thoubal","Thrissur","Tikamgarh","Tinsukia","Tirap","Tiruchirappalli","Tirunelveli","Tirupur","Tiruvallur","Tiruvannamalai","Tiruvarur","Tonk","Tuensang","Tumkur","Udaipur","Udalguri","Udham","Singh","Nagar","Udhampur","Udupi","Ujjain","Ukhrul","Umaria","Una","Unnao","Upper","Siang","Upper","Subansiri","Uttar","Dinajpur","Uttara","Kannada","Uttarkashi","Vadodara","Vaishali","Valsad","Varanasi","Vellore","Vidisha","Viluppuram","Virudhunagar","Visakhapatnam","Vizianagaram","Vyara","Warangal","Wardha","Washim","Wayanad","West","Champaran","West","Delhi","West","Garo","Hills","West","Kameng","West","Khasi","Hills","West","Siang","West","Sikkim","West","Singhbhum","West","Tripura","Wokha","Yadgir","Yamuna","Nagar","Yanam","Yavatmal","Zunheboto"
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase mFirebaseInstance = FirebaseDatabase.getInstance();
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        mFirebaseDatabase = mFirebaseInstance.getReference();
        final EditText name = findViewById(R.id.editText);
        final EditText mobile = findViewById(R.id.editText3);
        Button newb = findViewById(R.id.button2);
        final Spinner blood = findViewById(R.id.spinner);



        age = findViewById(R.id.agee);
       // b = findViewById(R.id.textView18);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,language);
        //Getting the instance of AutoCompleteTextView
        final AutoCompleteTextView actv = findViewById(R.id.textView18);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);

        newb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String location = actv.getText().toString();
                String dob = age.getText().toString();
                String name1 = name.getText().toString();
                String mobile1 = mobile.getText().toString();
                String blood1 = blood.getSelectedItem().toString();
                String combo = name1 + "," + mobile1 + "," + location + "," + dob;

                if (blood1.equals("") || mobile1.equals("") || location.equals("Tap to detect") || dob.equals("") ) {

                    Toast.makeText(MainActivity.this, "Please fill all the details.", Toast.LENGTH_SHORT).show();
                } else {
                    mFirebaseDatabase.child("users").child(blood1).child(mobile1).setValue(combo);

                    Toast.makeText(MainActivity.this, "Donor Added", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(MainActivity.this, Home.class);
                    startActivity(home);
                    finish();
                }
            }
        });





//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
//                        != PackageManager.PERMISSION_GRANTED) {
//                    requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1000);
//                } else {
//                    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//                    assert locationManager != null;
//                    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                    try {
//                        assert location != null;
//                        String city = hereLocation(location.getLatitude(), location.getLongitude());
//                        b.setText(city);
//                        Toast.makeText(MainActivity.this, "Awesome you're in " + city, Toast.LENGTH_LONG).show();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        Toast.makeText(MainActivity.this, "Please check if your GPS is turned on or open G-Maps and Position yourself ", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        if (requestCode == 1000) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                    return;
//                }
//                assert locationManager != null;
//                Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                try {
//                    assert location != null;
//                    String city = hereLocation(location.getLatitude(), location.getLongitude());
//                    b.setText(city);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(MainActivity.this, "Please check if your GPS is turned on or open G-Maps and Position yourself ", Toast.LENGTH_SHORT).show();
//                }
//   icon not showing on android studio         } else {
//                Toast t = Toast.makeText(this, "Permission not Granted", Toast.LENGTH_SHORT);
//                t.show();
//            }
//        }
//    }
//
//    private String hereLocation(double lat, double lon)
//    {
//        String cityName = "";
//        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
//        List<Address> addresses;
//        try {
//            addresses = geocoder.getFromLocation(lat,lon,10);
//            if (addresses.size() > 0){
//                for(Address adr: addresses){
//                    if (adr.getLocality() != null && adr.getLocality().length() > 0){
//                        cityName = adr.getLocality();
//                        break;
//                    }
//                }
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return cityName;
    }

    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (DatePickerDialog.OnDateSetListener) this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


}



