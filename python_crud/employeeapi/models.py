from django.db import models


class Employee(models.Model):
    fullName = models.CharField(max_length=100)
    empCode = models.CharField(max_length=3)
    mobile = models.CharField(max_length=15)

