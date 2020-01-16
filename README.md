# Create Easy way android apps by using Comet-i

##  5  simple steps to use it

1. add maven into project lavel Gradle
```
allprojects {
    repositories {
        maven { 
            url 'https://jitpack.io' 
        }
    }
}
```

2. add dependency into app lavel Gradle
```
implementation 'com.github.Cometi951:Comet-i:1.0.0'
```
3. extends your Activitys With BaseActivity 
4. implement methods SetActivity(), onClick()
5. return (this) in SetActivity method.
  
```
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected Activity SetActivity() {
        return this;
    }

    @Override
    public void onClick(View v) {
        
    }
    
}  
```
# once you done above steps, after you can use all features of this library. decrease lines of code into only 1 single line and make your project lightweight. you can replace your code by following below Examples.




## Toast

Toast.makeText(context, "message", Toast.LENGTH_SHORT).show();  
```
Toast("message");
```
  
## Intent

  Intent intent = new Intent(this, NextActivity.class);                                                                      
  startActivity(intent);
  
```
StartActivity(NextActivity.class);
```

Intent intent = new Intent(Intent.ACTION_VIEW);    
intent.setData(Uri.parse("https://www.example.com/"));                                                      
  startActivity(intent);
  
```
StartActivity("https://www.example.com/");
```

  Intent intent = new Intent(this, NextActivity.class);                                                                      
  intent.putExtra("String", "name");                                                                             
  intent.putExtra("int", 0);                                                                                 
  intent.putExtra("float", 0.0f);                                                                                  
  intent.putExtra("boolean", false);                                                                                                                                                               
  startActivity(intent);
  
```
StartActivity(NextActivity.class, new String[]{"String","int","float","boolean"}, new Object[]{"name", 0, 0.0f, false});
```

  Intent intent = new Intent(this, NextActivity.class);                                                                      
  intent.putExtra("ArrayList", arrayList);                                                                             
  intent.putExtra("ModelClass", modelclass);                                                                 
  intent.putExtra("Bundle",bundle);                                                                                     
  startActivity(intent);

```
StartActivity(NextActivity.class, new String[]{"ArrayList","ModelClass","Bundle"}, new Object[]{arrayList, modelclass, bundle});
```



Intent intent = new Intent(this, NextActivity.class);                                                                                
 startActivityForResult(intent, RequestCode);
  
```                                                                   
StartActivity(NextActivity.class, RequestCode);
```



Intent intent = new Intent(this, NextActivity.class);                                                              
intent.putExtra("String", "name");                                                        
startActivityForResult(intent, RequestCode);
  
```                                                                   
StartActivity(NextActivity.class, RequestCode, new String[]{"String"}, new Object[]{“name”});
```



Intent intent = new Intent(this, NextActivity.class);                                                            
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));                                         
startActivity(intent);
```
StartActivityWithClearAll(NextActivity.class);
```



  Intent intent = new Intent(this, NextActivity.class);                                                                                                   
  intent.putExtra("String", "name");                                                                          
  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));                               
  startActivity(intent);
  
```                                                                   
StartActivityWithClearAll(NextActivity.class, new String[]{"String"}, new Object[]{"name"});
```







## fragment

FragmentTransaction transaction = getFragmentManager().beginTransaction();                                               
 FragmentTest fragment = new FragmentTest();                                                                                 
 transaction.replace(R.id.frame, fragment, fragment.getClass().getSimpleName());                                           
 transaction.addToBackStack(null);                                                                                        
 transaction.commitAllowingStateLoss();

```
StartFragment(new FragmentTest(), R.id.frame);
```

 FragmentTransaction transaction = getFragmentManager().beginTransaction();                                      
 FragmentTest fragment = new FragmentTest();                                                                               
 fragment.setArguments(bundle);                                                                                         
 transaction.replace(R.id.frame, fragment, fragment.getClass().getSimpleName());                                   
 transaction.addToBackStack(null);                                                                                     
 transaction.commitAllowingStateLoss();                                                                              

```
StartFragment(new FragmentTest(), R.id.frame, bundle);
```


## getIntent
String s = getIntent().getStringExtra(“StringKey”);                                                              
```
String s = GetIntent(“StringKey”);
```
Bundle bundle = getIntent().getBundleExtra(“BundleKey”);                                                              
```
Bundle bundle = GetIntent(“BundleKey”);
```
Int I = getIntent().getIntExtra(“Key” , defaultValue);                                                               
```
Int I = GetIntent(“Key”, defaultValue);
```
Boolean b = getIntent().getBooleanExtra(“Key”, defaultValue);                                                           

```
Boolean b = GetIntent(“Key”, defaultValue);
```



ArrayList<MyClass> list = (ArrayList<MyClass>) getIntent().getExtras().getSerializable("myClassList");                
```
ArrayList<MyClass> list = GetIntent(“myClassList”);
```
    
MyClass dene = (MyClass )getIntent().getSerializableExtra("myClass");                                            
```
MyClass class = GetIntent(“myClass”);
```


## RecyclerView

####  Vertical
recyclerView = findViewById(R.id.recycler);                                                                
LinearLayoutManager layoutManager = new LinearLayoutManager(this);                                                  
recyclerView.setLayoutManager(layoutManager);                                                                       
recyclerView.setHasFixedSize(true);                                                                                

```
recyclerView = RecyclerViewVertical(recyclerView, R.id.recycler);
```

####  Horizontal
recyclerView = findViewById(R.id.recycler);                                                                    
LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);                  
recyclerView.setLayoutManager(layoutManager);                                                                      
recyclerView.setHasFixedSize(true);                                                                                

```
recyclerView = RecyclerViewHorizontal(recyclerView, R.id.recycler);
```

####  Grid
recyclerView = findViewById(R.id.recycler);                                                                      
recyclerView.setLayoutManager(new GridLayoutManager(activity, spanCount));                                              
recyclerView.setHasFixedSize(true);                                                                               


```
recyclerView = RecyclerViewGrid(recyclerView , R.id.recycler, spanCount);
```



## Shared Preferences
### by default generate one preference with your project package name. so you just need to call functions like below.


####  Save Value
SharedPreferences sharedpreferences = context.getSharedPreferences(YourPackageName, Context.MODE_PRIVATE);                 
Editor editor = sharedpreferences.edit();                                                                 
editor.putString("key", "value");                                                                                      
editor.commit();
                                  
```
SavePreference("key", "value");
```

####  Get Value
SharedPreferences sharedpreferences = context.getSharedPreferences(YourPackageName, Context.MODE_PRIVATE);              
String s = sharedpreferences.getInt("key");                                                                                                                                                                                                            
```
String s = GetPreferenceS("key");
```


####  Clear Preference 
SharedPreferences sharedpreferences = context.getSharedPreferences(YourPackageName, Context.MODE_PRIVATE);                 
Editor editor = sharedpreferences.edit();                                                                 
editor.clear();                                                                                                           
editor.commit();                                                                   
```
ClearPreference();
```

## most common variable context or activity which you don't have to declare and initialize on your activity, fragment, adapter. you just need to import activity variable that by default return your current exist activity. and you never get null pointer exception.

```
import static com.android.comet.I.library.Utility.activity;

funName(activity);
```
