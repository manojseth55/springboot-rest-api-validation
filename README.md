# springboot-rest-api-validation

## springboot-rest-api-validation Example of Spring-Boot-REST-API (User)


### 1. You can clone it from github by running following command 

```

$ git clone https://github.com/manojseth55/springboot-rest-api-validation.git

```

### 2. Import project into eclipse

```

  File -> Import -> Maven -> Existing Maven Projects -> Browse Project from cloned location
  
```

### 3. Right click on project in eclipse and then Maven -> Update Projects


### 4. Right click on SpringbootRestApiValidationApplication.java file and run as Java Application


Once Sprint Boot Application will be started successfully then we
can call following Endpoints by using POSTMAN


### 5. To check validation for User use following url with POST Request

```

  http://localhost:8080/users
  
```
  
####  set content type as in header as application/json

#### set request body as raw with JSON payload

#### 5.1 Valid payload
  
  ```
  
    {
        "name": "Mathew",
        "dateOfBirth": "2022-07-30T17:19:19.570+00:00"
    }

```
  
#### 5.2 Validate user name (it's length should be min 2 )
  
  ```
  
    {
        "name": "M",
        "dateOfBirth": "2022-07-30T17:19:19.570+00:00"
    }

```

will get validation failed error


```
{
    "timestamp": "2022-07-31T05:56:01.236+00:00",
    "message": "Method Argument Validation Failed",
    "details": "org.springframework.validation.BeanPropertyBindingResult: 1 errors\nField error in object 'user' on field 'name': rejected value [a]; codes [Size.user.name,Size.name,Size.java.lang.String,Size]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [user.name,name]; arguments []; default message [name],2147483647,2]; default message [name must have at least 2 character!]"
}
```

#### 5.3 Validate user date of birth (date should be past date from current date)
  
  ```
  
    {
        "name": "Mathew",
        "dateOfBirth": "2000-07-30T17:19:19.570+00:00"
    }

```

will get validation failed error


```
{
    "timestamp": "2022-07-31T08:23:41.480+00:00",
    "message": "Method Argument Validation Failed",
    "details": "org.springframework.validation.BeanPropertyBindingResult: 1 errors\nField error in object 'user' on field 'dateOfBirth': rejected value [Wed Jul 30 22:03:56 IST 2025]; codes [Past.user.dateOfBirth,Past.dateOfBirth,Past.java.util.Date,Past]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [user.dateOfBirth,dateOfBirth]; arguments []; default message [dateOfBirth]]; default message [date of birth should be past date from current date!]"
}
```


## There are many annotation to validation our model, listed below - 

#### AssertFalse - 

The annotated element must be false. Supported types are boolean and Boolean.

#### AssertTrue - 

The annotated element must be true. Supported types are boolean and Boolean.

#### DecimalMax - 

The annotated element must be a number whose value must be lower or equal to the specified maximum.

#### DecimalMin - 

The annotated element must be a number whose value must be higher or equal to the specified maximum.

#### Digits - 

The annotated element must be a number within accepted range. and null elements are considered valid.

#### Email - 

The string has to be a well-formed email address. Exact semantics of what makes up a valid email address are left to Jakarta Bean Validation providers. Accepts CharSequence. null elements are considered valid.

#### Future - 

The annotated element must be an instant, date or time in the future.

#### FutureOrPresent - 

The annotated element must be an instant, date or time in the present or in the future.

#### Max - 

The annotated element must be a number whose value must be lower or equal to the specified maximum.

#### Min - 

The annotated element must be a number whose value must be higher or equal to the specified maximum.

#### Negative  - 

The annotated element must be a strictly negative number (i.e. 0 is considered as an invalid value).

#### NegativeOrZero - 

The annotated element must be a negative number or 0.

#### NotBlank - 

The annotated element must not be null and must contain at least one non-whitespace character. Accepts CharSequence.

#### NotEmpty - 

The annotated element must not be null nor empty.

#### NotNull - 

The annotated element must not be null. Accepts any type.

#### Null - 

The annotated element must be null. Accepts any type.

#### Past - 

The annotated element must be an instant, date or time in the past.

#### PastOrPresent - 

The annotated element must be an instant, date or time in the past or in the present.

#### Pattern - 

The annotated CharSequence must match the specified regular expression. The regular expression follows the Java regular expression conventions see java.util.regex.Pattern.

#### Positive - 

The annotated element must be a strictly positive number (i.e. 0 is considered as an invalid value).

#### PositiveOrZero - 

The annotated element must be a positive number or 0.

#### Size  - 

The annotated element size must be between the specified boundaries (included).

  
