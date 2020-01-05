# Comet-i
Create Easy way android app by using it




### project lavel Gradle
```
allprojects {
    repositories {
        maven { 
            url 'https://jitpack.io' 
        }
    }
}

```

### app lavel Gradle
```
implementation 'com.github.Cometi951:Comet-i:1.0.0'
```





# Necessary steps
  1. extends your Activity With BaseActivity 
  2. implement methods SetActivity(), onClick()
  3. return (this) in SetActivity method.
  
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
                                                  |---------Keys---------|                       |-----Values-----|
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
  
````                                                                   
StartActivityWithClearAll(NextActivity.class, new String[]{"String"}, new Object[]{"name"});
````








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








