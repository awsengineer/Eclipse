import boto3

s3 = boto3.client('s3')
bucket_name="ztest1412"
encrytion_type="AES256"

for item in s3.list_objects_v2(Bucket=bucket_name)[u'Contents']:
    key = item[u'Key']
    print "Encrypting " + key + " to " + encrytion_type +" ...\n",
    s3.copy_object(
        Bucket=bucket_name,
        CopySource={
            'Bucket': bucket_name,
            'Key': key
        },
        Key=key,
        ServerSideEncryption=encrytion_type
     )

print "====\nDone!"
    