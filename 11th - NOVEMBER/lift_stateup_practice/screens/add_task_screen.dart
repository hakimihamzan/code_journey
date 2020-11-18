import 'package:flutter/material.dart';
import 'package:todoey_flutter/models/task.dart';

class AddTaskScreen extends StatelessWidget {
  final Function addTaskCallback;

  AddTaskScreen(this.addTaskCallback);
  @override
  Widget build(BuildContext context) {
    String taskAdded;
    return Container(
      color: Color(0xff757575),
      child: Container(
        padding: EdgeInsets.all(20.0),
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.only(
              topLeft: Radius.circular(20.0), topRight: Radius.circular(20.0)),
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text(
              'Add task',
              style: TextStyle(color: Colors.lightBlueAccent, fontSize: 30.0),
              textAlign: TextAlign.center,
            ),
            TextField(
              style: TextStyle(fontSize: 18.0),
              autofocus: true,
              textAlign: TextAlign.center,
              onChanged: (newTask) {
                taskAdded = newTask;
              },
            ),
            // SizedBox(
            //   height: 20.0,
            // ),
            FlatButton(
              // padding: EdgeInsets.all(15.0),
              color: Colors.lightBlueAccent,
              textColor: Color(0xff757575),

              onPressed: () {
                print(taskAdded);
                addTaskCallback(taskAdded);
              },
              child: Text(
                'Add',
                style: TextStyle(
                  color: Colors.white,
                  fontSize: 20.0,
                ),
              ),
            )
          ],
        ),
      ),
    );
  }
}
