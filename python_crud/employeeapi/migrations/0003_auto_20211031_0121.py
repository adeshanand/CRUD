# Generated by Django 3.0 on 2021-10-30 19:51

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('employeeapi', '0002_auto_20211030_2225'),
    ]

    operations = [
        migrations.RenameField(
            model_name='employee',
            old_name='emp_code',
            new_name='empCode',
        ),
        migrations.RenameField(
            model_name='employee',
            old_name='fullname',
            new_name='fullName',
        ),
    ]
