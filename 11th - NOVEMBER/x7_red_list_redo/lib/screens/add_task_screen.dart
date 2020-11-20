import 'package:flutter/material.dart';
import 'package:flutter/painting.dart';

class AddTaskScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      color: Color(0xff757575),
      child: Container(
        padding: EdgeInsets.all(20.0),
        decoration: BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.only(
              topLeft: Radius.circular(20.0),
              topRight: Radius.circular(20.0),
            )),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text(
              'Add task',
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 30.0, color: Colors.redAccent),
            ),
            TextField(
              style: TextStyle(fontSize: 20.0),
              cursorColor: Colors.redAccent,
              // style: TextStyle(color: Colors.redAccent),
              decoration: InputDecoration(
                focusedBorder: UnderlineInputBorder(
                  borderSide: BorderSide(width: 2, color: Colors.redAccent),
                ),
              ),
              autofocus: true,
              textAlign: TextAlign.center,
            ),
            FlatButton(
              color: Colors.redAccent,
              onPressed: () {
                print('tapped');
              },
              child: Text(
                'Add',
                style: TextStyle(color: Colors.white),
              ),
            )
          ],
        ),
      ),
    );
  }
}
