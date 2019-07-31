const functions = require('firebase-functions');

 const admin = require('firebase-admin');
 admin.initializeApp();
 exports.sendNotifications = functions.database.ref('/Notifications/{notification_id}/').onCreate((snapshot, context) => {
//exports.sendNotifications = functions.database.ref('/Users/{user_id}/Notifications/{notification_id}/') .onWrite((snapshot, context) => {
	
	 //notificationId 
	 const notification_id = context.params.notification_id; 
	 const deviceRef = admin.database().ref().child('Notifications').child(notification_id).once('value'); 
	 return deviceRef.then(queryResult => {
		 //senderId 
		 const from_userId = queryResult.val().from; 
		 const from_message = queryResult.val().message;
		  //receiver 
		 const user_id = queryResult.val().to;
		 //sender reference 
		 const from_data = admin.database().ref("Users/" + queryResult.val().from).once('value');
		 //receiver reference 
		 const to_data = admin.database().ref("Users/" + queryResult.val().to).once('value');
		 return Promise.all([from_data, to_data]).then(result => {
			 const from_name = result[0].val().name;
			 const to_userName = result[1].val().name;
			 const to_token = result[1].val().token_id;
			 const payload = {
				 notification: {
					 title: "Notification from " + from_name,
					 body: from_message,
					 icon: "ic_icon",
					 click_action: "com.karim.notification.TARGETNOTIFICATION"}, //change this 
					 data: {
						 message: from_message,
						 from_user_id: from_userId }
						 };
						 return admin.messaging().sendToDevice(to_token, payload).then(result => {
							 console.log("Notification Sent.");
							 return result;
							 }); 
						 });
					 });
				});