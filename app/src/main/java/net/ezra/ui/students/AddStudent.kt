package net.ezra.ui.students


import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter

import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import net.ezra.R
import java.util.UUID


@Composable
fun AddStudents(navController: NavHostController) {
    LazyColumn {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.black_background),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
                Column(

                    modifier = Modifier
                        .fillMaxSize()
//
                        .padding(5.dp),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(text = "Sign up to find work you love", color = Color.White)

                    var photoUri: Uri? by remember { mutableStateOf(null) }

                    val launcher =
                        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                            photoUri = uri
                        }


                    var firstname by rememberSaveable {
                        mutableStateOf("")
                    }

                    var lastname by rememberSaveable {
                        mutableStateOf("")
                    }

                    OutlinedTextField(
                        value = firstname,
                        onValueChange = { firstname = it },
                        label = { Text(text = "Fist Name", color = Color.Black) },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = lastname,
                        onValueChange = { lastname = it },
                        label = { Text(text = "Last Name", color = Color.Black) },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )


                    var email by rememberSaveable {
                        mutableStateOf("")
                    }

                    var occupation by rememberSaveable {
                        mutableStateOf("")
                    }

                    var country by rememberSaveable {
                        mutableStateOf("")
                    }





                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "Email", color = Color.White) },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )

                    OutlinedTextField(

                        value = occupation,
                        onValueChange = { occupation = it },
                        label = { Text(text = "Occupation", color = Color.White) },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = country,
                        onValueChange = { country = it },
                        label = { Text(text = "Country", color = Color.White) },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )


                    OutlinedButton(
                        onClick = {
                            launcher.launch(
                                PickVisualMediaRequest(
                                    //Here we request only photos. Change this to .ImageAndVideo if you want videos too.
                                    //Or use .VideoOnly if you only want videos.
                                    mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                )
                            )
                        }
                    ) {
                        Icon(imageVector = Icons.Default.AccountBox, contentDescription = "",)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Add a profile picture", color = Color.Gray)
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    if (photoUri != null) {
                        //Use Coil to display the selected image
                        val painter = rememberAsyncImagePainter(
                            ImageRequest
                                .Builder(LocalContext.current)
                                .data(data = photoUri)
                                .build()
                        )

                        Image(
                            painter = painter,
                            contentDescription = null,
                            modifier = Modifier
                                .background(color = Color.Transparent)
                                .padding(5.dp)
                                .size(150.dp)
                                .fillMaxWidth()
                                .border(1.dp, Color.Gray),
                            contentScale = ContentScale.Crop,

                            )
                    }


                    Button(
                        modifier = Modifier
//                .background(color = Color(0xff0606FF))
                        , onClick = {
                            photoUri?.let {
                                uploadImageToFirebaseStorage(
                                    it,
                                    firstname,
                                    lastname,
                                    email,
                                    occupation,
                                    country
                                )
                            }
                        }
                    ) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Register")
                    }


                }



            }
        }
    }
}



fun uploadImageToFirebaseStorage(
    imageUri: Uri,
    firstname: String,
    lastname: String,
    email: String,
    occupation: String,
    country: String
) {
    val storageRef = FirebaseStorage.getInstance().reference
    val imageRef = storageRef.child("images/${UUID.randomUUID()}")

    val uploadTask = imageRef.putFile(imageUri)
    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        imageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            saveToFirestore(
                downloadUri.toString(),
                firstname,
                lastname,
                email,
                occupation,
                country
            )
        } else {


        }
    }
}

fun saveToFirestore(
    imageUrl: String,
    firstname: String,
    lastname: String,
    email: String,
    occupation: String,
    country: String
) {
    val db = Firebase.firestore
    val imageInfo = hashMapOf(
        "imageUrl" to imageUrl,
        "First Name" to firstname,
        "Last Name" to lastname,
        "Email" to email,
        "Occupation" to occupation,
        "Country" to country,


        )




    db.collection("Sign_up")
        .add(imageInfo)
        .addOnSuccessListener {
            "Successfully sent"
        }
        .addOnFailureListener {
           " Handle  the error and try Again in a few minutes"
        }
}
@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    AddStudents(rememberNavController())
}




