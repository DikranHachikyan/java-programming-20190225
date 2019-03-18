#include "app_Main.h"

JNIEXPORT jlong JNICALL Java_app_Main_fact
  (JNIEnv *env, jobject obj, jint n){
  	if( n > 1){
  		return n * Java_app_Main_fact(env,obj, n-1 );
  	}
  	return 1;
}