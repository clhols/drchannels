#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class DrapiDate, DrapiProgramCard, DrapiMuPaging, DrapiSearchResult, DrapiKotlinArray<T>, DrapiMuScheduleBroadcast, DrapiSchedule, DrapiMuStreamingServer, DrapiChannel, DrapiMuStreamQuality, DrapiMuStream, DrapiMuNowNext, DrapiPrimaryAsset, DrapiInfo, DrapiLink, DrapiSubtitle, DrapiManifest, DrapiMostViewed, DrapiPrograms, DrapiPage, DrapiGenre, DrapiKtor_client_coreHttpClient, DrapiDrMuRepository, DrapiKotlinx_serialization_runtimeEnumDescriptor, DrapiKotlinx_serialization_runtimeSerialKind, DrapiKotlinNothing, DrapiKotlinx_serialization_runtimeUpdateMode, DrapiKtor_client_coreHttpClientEngineConfig, DrapiKtor_client_coreHttpClientConfig<T>, DrapiKotlinx_coroutines_coreCoroutineDispatcher, DrapiKtor_client_coreHttpReceivePipeline, DrapiKtor_client_coreHttpRequestPipeline, DrapiKtor_client_coreHttpResponsePipeline, DrapiKtor_client_coreHttpSendPipeline, DrapiKotlinThrowable, DrapiKotlinx_coroutines_coreCancellationException, DrapiKotlinx_serialization_runtimeSerialClassDescImpl, DrapiKotlinEnum<E>, DrapiKtor_client_coreHttpResponseConfig, DrapiKtor_utilsAttributeKey<T>, DrapiKotlinAbstractCoroutineContextElement, DrapiKtor_utilsPipelinePhase, DrapiKtor_utilsPipeline<TSubject, TContext>, DrapiKtor_client_coreHttpResponse, DrapiKtor_client_coreHttpClientCall, DrapiKtor_client_coreHttpRequestBuilder, DrapiKtor_client_coreHttpResponseContainer, DrapiKotlinException, DrapiKotlinRuntimeException, DrapiKotlinIllegalStateException, DrapiKotlinx_ioCharset, DrapiKtor_utilsGMTDate, DrapiKtor_httpHttpStatusCode, DrapiKtor_httpHttpProtocolVersion, DrapiKtor_httpHeadersBuilder, DrapiKtor_client_coreHttpRequestData, DrapiKtor_httpURLBuilder, DrapiKtor_httpHttpMethod, DrapiKtor_client_coreTypeInfo, DrapiKotlinx_coroutines_coreAtomicDesc, DrapiKotlinx_ioCharsetDecoder, DrapiKotlinx_ioCharsetEncoder, DrapiKotlinx_ioByteOrder, DrapiKtor_utilsWeekDay, DrapiKtor_utilsMonth, DrapiKtor_httpOutgoingContent, DrapiKtor_httpUrl, DrapiKtor_utilsStringValuesBuilder, DrapiKtor_httpURLProtocol, DrapiKtor_httpParametersBuilder, DrapiKotlinx_coroutines_coreAtomicOp<__contravariant T>, DrapiKotlinx_ioIoBuffer, DrapiKtor_httpContentType, DrapiKotlinx_coroutines_coreOpDescriptor, DrapiKotlinByteArray, DrapiKotlinDoubleArray, DrapiKotlinFloatArray, DrapiKotlinIntArray, DrapiKotlinLongArray, DrapiKotlinShortArray, DrapiKotlinCharArray, DrapiKtor_httpHeaderValueParam, DrapiKtor_httpHeaderValueWithParameters, DrapiKotlinByteIterator, DrapiKotlinDoubleIterator, DrapiKotlinFloatIterator, DrapiKotlinIntIterator, DrapiKotlinLongIterator, DrapiKotlinShortIterator, DrapiKotlinCharIterator;

@protocol DrapiKotlinx_serialization_runtimeEncoder, DrapiKotlinx_serialization_runtimeSerialDescriptor, DrapiKotlinx_serialization_runtimeDecoder, DrapiKotlinCoroutineContext, DrapiKotlinx_coroutines_coreJob, DrapiKotlinx_serialization_runtimeCompositeEncoder, DrapiKotlinx_serialization_runtimeSerialModule, DrapiKotlinAnnotation, DrapiKotlinx_serialization_runtimeCompositeDecoder, DrapiKotlinIterator, DrapiKtor_client_coreHttpClientEngine, DrapiKtor_utilsAttributes, DrapiKotlinCoroutineContextElement, DrapiKotlinCoroutineContextKey, DrapiKotlinx_coroutines_coreChildHandle, DrapiKotlinx_coroutines_coreChildJob, DrapiKotlinx_coroutines_coreDisposableHandle, DrapiKotlinSequence, DrapiKotlinx_coroutines_coreSelectClause0, DrapiKotlinx_serialization_runtimeSerialModuleCollector, DrapiKotlinKClass, DrapiKtor_client_coreHttpClientFeature, DrapiKotlinContinuation, DrapiKotlinx_coroutines_coreRunnable, DrapiKotlinSuspendFunction2, DrapiKotlinx_coroutines_coreParentJob, DrapiKotlinx_coroutines_coreSelectInstance, DrapiKotlinSuspendFunction0, DrapiKtor_httpHeaders, DrapiKotlinx_coroutines_ioByteReadChannel, DrapiKtor_client_coreHttpRequest, DrapiKotlinMapEntry, DrapiKotlinx_coroutines_ioReadSession, DrapiKtor_client_coreType, DrapiKtor_httpParameters, DrapiKotlinAppendable, DrapiKotlinx_ioObjectPool;

NS_ASSUME_NONNULL_BEGIN

@interface KotlinBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface KotlinBase (KotlinBaseCopying) <NSCopying>
@end;

__attribute__((objc_runtime_name("KotlinMutableSet")))
__attribute__((swift_name("KotlinMutableSet")))
@interface DrapiMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((objc_runtime_name("KotlinMutableDictionary")))
__attribute__((swift_name("KotlinMutableDictionary")))
@interface DrapiMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((objc_runtime_name("KotlinNumber")))
__attribute__((swift_name("KotlinNumber")))
@interface DrapiNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((objc_runtime_name("KotlinByte")))
__attribute__((swift_name("KotlinByte")))
@interface DrapiByte : DrapiNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((objc_runtime_name("KotlinUByte")))
__attribute__((swift_name("KotlinUByte")))
@interface DrapiUByte : DrapiNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((objc_runtime_name("KotlinShort")))
__attribute__((swift_name("KotlinShort")))
@interface DrapiShort : DrapiNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((objc_runtime_name("KotlinUShort")))
__attribute__((swift_name("KotlinUShort")))
@interface DrapiUShort : DrapiNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((objc_runtime_name("KotlinInt")))
__attribute__((swift_name("KotlinInt")))
@interface DrapiInt : DrapiNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((objc_runtime_name("KotlinUInt")))
__attribute__((swift_name("KotlinUInt")))
@interface DrapiUInt : DrapiNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((objc_runtime_name("KotlinLong")))
__attribute__((swift_name("KotlinLong")))
@interface DrapiLong : DrapiNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((objc_runtime_name("KotlinULong")))
__attribute__((swift_name("KotlinULong")))
@interface DrapiULong : DrapiNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((objc_runtime_name("KotlinFloat")))
__attribute__((swift_name("KotlinFloat")))
@interface DrapiFloat : DrapiNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((objc_runtime_name("KotlinDouble")))
__attribute__((swift_name("KotlinDouble")))
@interface DrapiDouble : DrapiNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((objc_runtime_name("KotlinBoolean")))
__attribute__((swift_name("KotlinBoolean")))
@interface DrapiBoolean : DrapiNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Date")))
@interface DrapiDate : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSString *)description __attribute__((swift_name("description()")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
@property int64_t time __attribute__((swift_name("time")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeSerializationStrategy")))
@protocol DrapiKotlinx_serialization_runtimeSerializationStrategy
@required
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(id _Nullable)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeDeserializationStrategy")))
@protocol DrapiKotlinx_serialization_runtimeDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (id _Nullable)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(id _Nullable)old __attribute__((swift_name("patch(decoder:old:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeKSerializer")))
@protocol DrapiKotlinx_serialization_runtimeKSerializer <DrapiKotlinx_serialization_runtimeSerializationStrategy, DrapiKotlinx_serialization_runtimeDeserializationStrategy>
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DateSerializer")))
@interface DrapiDateSerializer : KotlinBase <DrapiKotlinx_serialization_runtimeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)dateSerializer __attribute__((swift_name("init()")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiDate *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
- (DrapiDate *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiDate *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiDate *)old __attribute__((swift_name("patch(decoder:old:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchResult")))
@interface DrapiSearchResult : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Title:(NSString * _Nullable)Title Subtitle:(NSString * _Nullable)Subtitle Description:(NSString * _Nullable)Description IsRepremiere:(BOOL)IsRepremiere BundleType:(NSString * _Nullable)BundleType ThemeType:(NSString * _Nullable)ThemeType Slug:(NSString * _Nullable)Slug Items:(NSArray<DrapiProgramCard *> * _Nullable)Items Paging:(DrapiMuPaging * _Nullable)Paging TotalSize:(int32_t)TotalSize BackgroundImageUri:(NSString * _Nullable)BackgroundImageUri SiteUrl:(NSString * _Nullable)SiteUrl serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Title:Subtitle:Description:IsRepremiere:BundleType:ThemeType:Slug:Items:Paging:TotalSize:BackgroundImageUri:SiteUrl:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithTitle:(NSString *)Title Subtitle:(NSString *)Subtitle Description:(NSString *)Description IsRepremiere:(BOOL)IsRepremiere BundleType:(NSString *)BundleType ThemeType:(NSString *)ThemeType Slug:(NSString *)Slug Items:(NSArray<DrapiProgramCard *> *)Items Paging:(DrapiMuPaging *)Paging TotalSize:(int32_t)TotalSize BackgroundImageUri:(NSString *)BackgroundImageUri SiteUrl:(NSString *)SiteUrl __attribute__((swift_name("init(Title:Subtitle:Description:IsRepremiere:BundleType:ThemeType:Slug:Items:Paging:TotalSize:BackgroundImageUri:SiteUrl:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (BOOL)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (NSString *)component6 __attribute__((swift_name("component6()")));
- (NSString *)component7 __attribute__((swift_name("component7()")));
- (NSArray<DrapiProgramCard *> *)component8 __attribute__((swift_name("component8()")));
- (DrapiMuPaging *)component9 __attribute__((swift_name("component9()")));
- (int32_t)component10 __attribute__((swift_name("component10()")));
- (NSString *)component11 __attribute__((swift_name("component11()")));
- (NSString *)component12 __attribute__((swift_name("component12()")));
- (DrapiSearchResult *)doCopyTitle:(NSString *)Title Subtitle:(NSString *)Subtitle Description:(NSString *)Description IsRepremiere:(BOOL)IsRepremiere BundleType:(NSString *)BundleType ThemeType:(NSString *)ThemeType Slug:(NSString *)Slug Items:(NSArray<DrapiProgramCard *> *)Items Paging:(DrapiMuPaging *)Paging TotalSize:(int32_t)TotalSize BackgroundImageUri:(NSString *)BackgroundImageUri SiteUrl:(NSString *)SiteUrl __attribute__((swift_name("doCopy(Title:Subtitle:Description:IsRepremiere:BundleType:ThemeType:Slug:Items:Paging:TotalSize:BackgroundImageUri:SiteUrl:)")));
@property (readonly) NSString *Title __attribute__((swift_name("Title")));
@property (readonly) NSString *Subtitle __attribute__((swift_name("Subtitle")));
@property (readonly) NSString *Description __attribute__((swift_name("Description")));
@property (readonly) BOOL IsRepremiere __attribute__((swift_name("IsRepremiere")));
@property (readonly) NSString *BundleType __attribute__((swift_name("BundleType")));
@property (readonly) NSString *ThemeType __attribute__((swift_name("ThemeType")));
@property (readonly) NSString *Slug __attribute__((swift_name("Slug")));
@property (readonly) NSArray<DrapiProgramCard *> *Items __attribute__((swift_name("Items")));
@property (readonly) DrapiMuPaging *Paging __attribute__((swift_name("Paging")));
@property (readonly) int32_t TotalSize __attribute__((swift_name("TotalSize")));
@property (readonly) NSString *BackgroundImageUri __attribute__((swift_name("BackgroundImageUri")));
@property (readonly) NSString *SiteUrl __attribute__((swift_name("SiteUrl")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchResult.Companion")))
@interface DrapiSearchResultCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeGeneratedSerializer")))
@protocol DrapiKotlinx_serialization_runtimeGeneratedSerializer <DrapiKotlinx_serialization_runtimeKSerializer>
@required
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchResult.$serializer")))
@interface DrapiSearchResult$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiSearchResult *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiSearchResult *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiSearchResult *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiSearchResult *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuPaging")))
@interface DrapiMuPaging : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Title:(NSString * _Nullable)Title Source:(NSString * _Nullable)Source Next:(NSString * _Nullable)Next Previous:(NSString * _Nullable)Previous TotalSize:(int32_t)TotalSize serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Title:Source:Next:Previous:TotalSize:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithTitle:(NSString *)Title Source:(NSString *)Source Next:(NSString *)Next Previous:(NSString *)Previous TotalSize:(int32_t)TotalSize __attribute__((swift_name("init(Title:Source:Next:Previous:TotalSize:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (int32_t)component5 __attribute__((swift_name("component5()")));
- (DrapiMuPaging *)doCopyTitle:(NSString *)Title Source:(NSString *)Source Next:(NSString *)Next Previous:(NSString *)Previous TotalSize:(int32_t)TotalSize __attribute__((swift_name("doCopy(Title:Source:Next:Previous:TotalSize:)")));
@property (readonly) NSString *Title __attribute__((swift_name("Title")));
@property (readonly) NSString *Source __attribute__((swift_name("Source")));
@property (readonly) NSString *Next __attribute__((swift_name("Next")));
@property (readonly) NSString *Previous __attribute__((swift_name("Previous")));
@property (readonly) int32_t TotalSize __attribute__((swift_name("TotalSize")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuPaging.Companion")))
@interface DrapiMuPagingCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuPaging.$serializer")))
@interface DrapiMuPaging$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiMuPaging *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuPaging *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiMuPaging *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiMuPaging *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Schedule")))
@interface DrapiSchedule : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Broadcasts:(NSArray<DrapiMuScheduleBroadcast *> * _Nullable)Broadcasts BroadcastDate:(DrapiDate * _Nullable)BroadcastDate ChannelSlug:(NSString * _Nullable)ChannelSlug Channel:(NSString * _Nullable)Channel serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Broadcasts:BroadcastDate:ChannelSlug:Channel:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithBroadcasts:(NSArray<DrapiMuScheduleBroadcast *> *)Broadcasts BroadcastDate:(DrapiDate *)BroadcastDate ChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel __attribute__((swift_name("init(Broadcasts:BroadcastDate:ChannelSlug:Channel:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSArray<DrapiMuScheduleBroadcast *> *)component1 __attribute__((swift_name("component1()")));
- (DrapiDate *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (DrapiSchedule *)doCopyBroadcasts:(NSArray<DrapiMuScheduleBroadcast *> *)Broadcasts BroadcastDate:(DrapiDate *)BroadcastDate ChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel __attribute__((swift_name("doCopy(Broadcasts:BroadcastDate:ChannelSlug:Channel:)")));
@property (readonly) NSArray<DrapiMuScheduleBroadcast *> *Broadcasts __attribute__((swift_name("Broadcasts")));
@property (readonly) DrapiDate *BroadcastDate __attribute__((swift_name("BroadcastDate")));
@property (readonly) NSString *ChannelSlug __attribute__((swift_name("ChannelSlug")));
@property (readonly) NSString *Channel __attribute__((swift_name("Channel")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Schedule.Companion")))
@interface DrapiScheduleCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Schedule.$serializer")))
@interface DrapiSchedule$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiSchedule *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiSchedule *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiSchedule *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiSchedule *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Channel")))
@interface DrapiChannel : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Type:(NSString * _Nullable)Type StreamingServers:(NSArray<DrapiMuStreamingServer *> * _Nullable)StreamingServers Url:(NSString * _Nullable)Url SourceUrl:(NSString * _Nullable)SourceUrl WebChannel:(BOOL)WebChannel Slug:(NSString * _Nullable)Slug Urn:(NSString * _Nullable)Urn PrimaryImageUri:(NSString * _Nullable)PrimaryImageUri PresentationUri:(NSString * _Nullable)PresentationUri PresentationUriAutoplay:(NSString * _Nullable)PresentationUriAutoplay Title:(NSString * _Nullable)Title ItemLabel:(NSString * _Nullable)ItemLabel Subtitle:(NSString * _Nullable)Subtitle serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Type:StreamingServers:Url:SourceUrl:WebChannel:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:ItemLabel:Subtitle:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithType:(NSString *)Type StreamingServers:(NSArray<DrapiMuStreamingServer *> *)StreamingServers Url:(NSString *)Url SourceUrl:(NSString *)SourceUrl WebChannel:(BOOL)WebChannel Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title ItemLabel:(NSString *)ItemLabel Subtitle:(NSString *)Subtitle __attribute__((swift_name("init(Type:StreamingServers:Url:SourceUrl:WebChannel:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:ItemLabel:Subtitle:)"))) __attribute__((objc_designated_initializer));
- (DrapiMuStreamingServer * _Nullable)server __attribute__((swift_name("server()")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSArray<DrapiMuStreamingServer *> *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (BOOL)component5 __attribute__((swift_name("component5()")));
- (NSString *)component6 __attribute__((swift_name("component6()")));
- (NSString *)component7 __attribute__((swift_name("component7()")));
- (NSString *)component8 __attribute__((swift_name("component8()")));
- (NSString *)component9 __attribute__((swift_name("component9()")));
- (NSString *)component10 __attribute__((swift_name("component10()")));
- (NSString *)component11 __attribute__((swift_name("component11()")));
- (NSString *)component12 __attribute__((swift_name("component12()")));
- (NSString *)component13 __attribute__((swift_name("component13()")));
- (DrapiChannel *)doCopyType:(NSString *)Type StreamingServers:(NSArray<DrapiMuStreamingServer *> *)StreamingServers Url:(NSString *)Url SourceUrl:(NSString *)SourceUrl WebChannel:(BOOL)WebChannel Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title ItemLabel:(NSString *)ItemLabel Subtitle:(NSString *)Subtitle __attribute__((swift_name("doCopy(Type:StreamingServers:Url:SourceUrl:WebChannel:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:ItemLabel:Subtitle:)")));
@property (readonly) NSString *Type __attribute__((swift_name("Type")));
@property (readonly) NSArray<DrapiMuStreamingServer *> *StreamingServers __attribute__((swift_name("StreamingServers")));
@property (readonly) NSString *Url __attribute__((swift_name("Url")));
@property (readonly) NSString *SourceUrl __attribute__((swift_name("SourceUrl")));
@property (readonly) BOOL WebChannel __attribute__((swift_name("WebChannel")));
@property (readonly) NSString *Slug __attribute__((swift_name("Slug")));
@property (readonly) NSString *Urn __attribute__((swift_name("Urn")));
@property (readonly) NSString *PrimaryImageUri __attribute__((swift_name("PrimaryImageUri")));
@property (readonly) NSString *PresentationUri __attribute__((swift_name("PresentationUri")));
@property (readonly) NSString *PresentationUriAutoplay __attribute__((swift_name("PresentationUriAutoplay")));
@property (readonly) NSString *Title __attribute__((swift_name("Title")));
@property (readonly) NSString *ItemLabel __attribute__((swift_name("ItemLabel")));
@property (readonly) NSString *Subtitle __attribute__((swift_name("Subtitle")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Channel.Companion")))
@interface DrapiChannelCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Channel.$serializer")))
@interface DrapiChannel$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiChannel *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiChannel *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiChannel *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiChannel *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamingServer")))
@interface DrapiMuStreamingServer : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Server:(NSString * _Nullable)Server LinkType:(NSString * _Nullable)LinkType Qualities:(NSArray<DrapiMuStreamQuality *> * _Nullable)Qualities DynamicUserQualityChange:(BOOL)DynamicUserQualityChange EncryptedServer:(NSString * _Nullable)EncryptedServer serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Server:LinkType:Qualities:DynamicUserQualityChange:EncryptedServer:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithServer:(NSString *)Server LinkType:(NSString *)LinkType Qualities:(NSArray<DrapiMuStreamQuality *> *)Qualities DynamicUserQualityChange:(BOOL)DynamicUserQualityChange EncryptedServer:(NSString *)EncryptedServer __attribute__((swift_name("init(Server:LinkType:Qualities:DynamicUserQualityChange:EncryptedServer:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSArray<DrapiMuStreamQuality *> *)component3 __attribute__((swift_name("component3()")));
- (BOOL)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (DrapiMuStreamingServer *)doCopyServer:(NSString *)Server LinkType:(NSString *)LinkType Qualities:(NSArray<DrapiMuStreamQuality *> *)Qualities DynamicUserQualityChange:(BOOL)DynamicUserQualityChange EncryptedServer:(NSString *)EncryptedServer __attribute__((swift_name("doCopy(Server:LinkType:Qualities:DynamicUserQualityChange:EncryptedServer:)")));
@property (readonly) NSString *Server __attribute__((swift_name("Server")));
@property (readonly) NSString *LinkType __attribute__((swift_name("LinkType")));
@property (readonly) NSArray<DrapiMuStreamQuality *> *Qualities __attribute__((swift_name("Qualities")));
@property (readonly) BOOL DynamicUserQualityChange __attribute__((swift_name("DynamicUserQualityChange")));
@property (readonly) NSString *EncryptedServer __attribute__((swift_name("EncryptedServer")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamingServer.Companion")))
@interface DrapiMuStreamingServerCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamingServer.$serializer")))
@interface DrapiMuStreamingServer$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiMuStreamingServer *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuStreamingServer *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiMuStreamingServer *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiMuStreamingServer *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamQuality")))
@interface DrapiMuStreamQuality : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Kbps:(int32_t)Kbps Streams:(NSArray<DrapiMuStream *> * _Nullable)Streams serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Kbps:Streams:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithKbps:(int32_t)Kbps Streams:(NSArray<DrapiMuStream *> *)Streams __attribute__((swift_name("init(Kbps:Streams:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSArray<DrapiMuStream *> *)component2 __attribute__((swift_name("component2()")));
- (DrapiMuStreamQuality *)doCopyKbps:(int32_t)Kbps Streams:(NSArray<DrapiMuStream *> *)Streams __attribute__((swift_name("doCopy(Kbps:Streams:)")));
@property (readonly) int32_t Kbps __attribute__((swift_name("Kbps")));
@property (readonly) NSArray<DrapiMuStream *> *Streams __attribute__((swift_name("Streams")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamQuality.Companion")))
@interface DrapiMuStreamQualityCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamQuality.$serializer")))
@interface DrapiMuStreamQuality$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiMuStreamQuality *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuStreamQuality *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiMuStreamQuality *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiMuStreamQuality *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStream")))
@interface DrapiMuStream : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Stream:(NSString * _Nullable)Stream EncryptedStream:(NSString * _Nullable)EncryptedStream serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Stream:EncryptedStream:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithStream:(NSString *)Stream EncryptedStream:(NSString *)EncryptedStream __attribute__((swift_name("init(Stream:EncryptedStream:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (DrapiMuStream *)doCopyStream:(NSString *)Stream EncryptedStream:(NSString *)EncryptedStream __attribute__((swift_name("doCopy(Stream:EncryptedStream:)")));
@property (readonly) NSString *Stream __attribute__((swift_name("Stream")));
@property (readonly) NSString *EncryptedStream __attribute__((swift_name("EncryptedStream")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStream.Companion")))
@interface DrapiMuStreamCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStream.$serializer")))
@interface DrapiMuStream$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiMuStream *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuStream *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiMuStream *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiMuStream *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuNowNext")))
@interface DrapiMuNowNext : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 ChannelSlug:(NSString * _Nullable)ChannelSlug Channel:(NSString * _Nullable)Channel Now:(DrapiMuScheduleBroadcast * _Nullable)Now Next:(NSArray<DrapiMuScheduleBroadcast *> * _Nullable)Next serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:ChannelSlug:Channel:Now:Next:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel Now:(DrapiMuScheduleBroadcast * _Nullable)Now Next:(NSArray<DrapiMuScheduleBroadcast *> *)Next __attribute__((swift_name("init(ChannelSlug:Channel:Now:Next:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (DrapiMuScheduleBroadcast * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSArray<DrapiMuScheduleBroadcast *> *)component4 __attribute__((swift_name("component4()")));
- (DrapiMuNowNext *)doCopyChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel Now:(DrapiMuScheduleBroadcast * _Nullable)Now Next:(NSArray<DrapiMuScheduleBroadcast *> *)Next __attribute__((swift_name("doCopy(ChannelSlug:Channel:Now:Next:)")));
@property (readonly) NSString *ChannelSlug __attribute__((swift_name("ChannelSlug")));
@property (readonly) NSString *Channel __attribute__((swift_name("Channel")));
@property (readonly) DrapiMuScheduleBroadcast * _Nullable Now __attribute__((swift_name("Now")));
@property (readonly) NSArray<DrapiMuScheduleBroadcast *> *Next __attribute__((swift_name("Next")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuNowNext.Companion")))
@interface DrapiMuNowNextCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuNowNext.$serializer")))
@interface DrapiMuNowNext$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiMuNowNext *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuNowNext *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiMuNowNext *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiMuNowNext *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuScheduleBroadcast")))
@interface DrapiMuScheduleBroadcast : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Title:(NSString * _Nullable)Title Description:(NSString * _Nullable)Description Subtitle:(NSString * _Nullable)Subtitle StartTime:(DrapiDate * _Nullable)StartTime EndTime:(DrapiDate * _Nullable)EndTime ProgramCard:(DrapiProgramCard * _Nullable)ProgramCard OnlineGenreText:(NSString * _Nullable)OnlineGenreText ProductionNumber:(NSString * _Nullable)ProductionNumber ProgramCardHasPrimaryAsset:(BOOL)ProgramCardHasPrimaryAsset SeriesHasProgramCardWithPrimaryAsset:(BOOL)SeriesHasProgramCardWithPrimaryAsset AnnouncedStartTime:(DrapiDate * _Nullable)AnnouncedStartTime AnnouncedEndTime:(DrapiDate * _Nullable)AnnouncedEndTime ProductionCountry:(NSString * _Nullable)ProductionCountry ProductionYear:(int32_t)ProductionYear VideoWidescreen:(BOOL)VideoWidescreen SubtitlesTTV:(BOOL)SubtitlesTTV VideoHD:(BOOL)VideoHD WhatsOnUri:(NSString * _Nullable)WhatsOnUri IsRerun:(BOOL)IsRerun serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Title:Description:Subtitle:StartTime:EndTime:ProgramCard:OnlineGenreText:ProductionNumber:ProgramCardHasPrimaryAsset:SeriesHasProgramCardWithPrimaryAsset:AnnouncedStartTime:AnnouncedEndTime:ProductionCountry:ProductionYear:VideoWidescreen:SubtitlesTTV:VideoHD:WhatsOnUri:IsRerun:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithTitle:(NSString *)Title Description:(NSString *)Description Subtitle:(NSString *)Subtitle StartTime:(DrapiDate *)StartTime EndTime:(DrapiDate *)EndTime ProgramCard:(DrapiProgramCard *)ProgramCard OnlineGenreText:(NSString * _Nullable)OnlineGenreText ProductionNumber:(NSString *)ProductionNumber ProgramCardHasPrimaryAsset:(BOOL)ProgramCardHasPrimaryAsset SeriesHasProgramCardWithPrimaryAsset:(BOOL)SeriesHasProgramCardWithPrimaryAsset AnnouncedStartTime:(DrapiDate *)AnnouncedStartTime AnnouncedEndTime:(DrapiDate *)AnnouncedEndTime ProductionCountry:(NSString *)ProductionCountry ProductionYear:(int32_t)ProductionYear VideoWidescreen:(BOOL)VideoWidescreen SubtitlesTTV:(BOOL)SubtitlesTTV VideoHD:(BOOL)VideoHD WhatsOnUri:(NSString *)WhatsOnUri IsRerun:(BOOL)IsRerun __attribute__((swift_name("init(Title:Description:Subtitle:StartTime:EndTime:ProgramCard:OnlineGenreText:ProductionNumber:ProgramCardHasPrimaryAsset:SeriesHasProgramCardWithPrimaryAsset:AnnouncedStartTime:AnnouncedEndTime:ProductionCountry:ProductionYear:VideoWidescreen:SubtitlesTTV:VideoHD:WhatsOnUri:IsRerun:)"))) __attribute__((objc_designated_initializer));
- (NSString * _Nullable)getPrimaryAssetUri __attribute__((swift_name("getPrimaryAssetUri()")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (DrapiDate *)component4 __attribute__((swift_name("component4()")));
- (DrapiDate *)component5 __attribute__((swift_name("component5()")));
- (DrapiProgramCard *)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (NSString *)component8 __attribute__((swift_name("component8()")));
- (BOOL)component9 __attribute__((swift_name("component9()")));
- (BOOL)component10 __attribute__((swift_name("component10()")));
- (DrapiDate *)component11 __attribute__((swift_name("component11()")));
- (DrapiDate *)component12 __attribute__((swift_name("component12()")));
- (NSString *)component13 __attribute__((swift_name("component13()")));
- (int32_t)component14 __attribute__((swift_name("component14()")));
- (BOOL)component15 __attribute__((swift_name("component15()")));
- (BOOL)component16 __attribute__((swift_name("component16()")));
- (BOOL)component17 __attribute__((swift_name("component17()")));
- (NSString *)component18 __attribute__((swift_name("component18()")));
- (BOOL)component19 __attribute__((swift_name("component19()")));
- (DrapiMuScheduleBroadcast *)doCopyTitle:(NSString *)Title Description:(NSString *)Description Subtitle:(NSString *)Subtitle StartTime:(DrapiDate *)StartTime EndTime:(DrapiDate *)EndTime ProgramCard:(DrapiProgramCard *)ProgramCard OnlineGenreText:(NSString * _Nullable)OnlineGenreText ProductionNumber:(NSString *)ProductionNumber ProgramCardHasPrimaryAsset:(BOOL)ProgramCardHasPrimaryAsset SeriesHasProgramCardWithPrimaryAsset:(BOOL)SeriesHasProgramCardWithPrimaryAsset AnnouncedStartTime:(DrapiDate *)AnnouncedStartTime AnnouncedEndTime:(DrapiDate *)AnnouncedEndTime ProductionCountry:(NSString *)ProductionCountry ProductionYear:(int32_t)ProductionYear VideoWidescreen:(BOOL)VideoWidescreen SubtitlesTTV:(BOOL)SubtitlesTTV VideoHD:(BOOL)VideoHD WhatsOnUri:(NSString *)WhatsOnUri IsRerun:(BOOL)IsRerun __attribute__((swift_name("doCopy(Title:Description:Subtitle:StartTime:EndTime:ProgramCard:OnlineGenreText:ProductionNumber:ProgramCardHasPrimaryAsset:SeriesHasProgramCardWithPrimaryAsset:AnnouncedStartTime:AnnouncedEndTime:ProductionCountry:ProductionYear:VideoWidescreen:SubtitlesTTV:VideoHD:WhatsOnUri:IsRerun:)")));
@property (readonly) NSString *Title __attribute__((swift_name("Title")));
@property (readonly) NSString *Description __attribute__((swift_name("Description")));
@property (readonly) NSString *Subtitle __attribute__((swift_name("Subtitle")));
@property (readonly) DrapiDate *StartTime __attribute__((swift_name("StartTime")));
@property (readonly) DrapiDate *EndTime __attribute__((swift_name("EndTime")));
@property (readonly) DrapiProgramCard *ProgramCard __attribute__((swift_name("ProgramCard")));
@property (readonly) NSString * _Nullable OnlineGenreText __attribute__((swift_name("OnlineGenreText")));
@property (readonly) NSString *ProductionNumber __attribute__((swift_name("ProductionNumber")));
@property (readonly) BOOL ProgramCardHasPrimaryAsset __attribute__((swift_name("ProgramCardHasPrimaryAsset")));
@property (readonly) BOOL SeriesHasProgramCardWithPrimaryAsset __attribute__((swift_name("SeriesHasProgramCardWithPrimaryAsset")));
@property (readonly) DrapiDate *AnnouncedStartTime __attribute__((swift_name("AnnouncedStartTime")));
@property (readonly) DrapiDate *AnnouncedEndTime __attribute__((swift_name("AnnouncedEndTime")));
@property (readonly) NSString *ProductionCountry __attribute__((swift_name("ProductionCountry")));
@property (readonly) int32_t ProductionYear __attribute__((swift_name("ProductionYear")));
@property (readonly) BOOL VideoWidescreen __attribute__((swift_name("VideoWidescreen")));
@property (readonly) BOOL SubtitlesTTV __attribute__((swift_name("SubtitlesTTV")));
@property (readonly) BOOL VideoHD __attribute__((swift_name("VideoHD")));
@property (readonly) NSString *WhatsOnUri __attribute__((swift_name("WhatsOnUri")));
@property (readonly) BOOL IsRerun __attribute__((swift_name("IsRerun")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuScheduleBroadcast.Companion")))
@interface DrapiMuScheduleBroadcastCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuScheduleBroadcast.$serializer")))
@interface DrapiMuScheduleBroadcast$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiMuScheduleBroadcast *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuScheduleBroadcast *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiMuScheduleBroadcast *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiMuScheduleBroadcast *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProgramCard")))
@interface DrapiProgramCard : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 seen2:(int32_t)seen2 Type:(NSString * _Nullable)Type SeriesTitle:(NSString * _Nullable)SeriesTitle EpisodeTitle:(NSString * _Nullable)EpisodeTitle SeriesSlug:(NSString * _Nullable)SeriesSlug SeriesUrn:(NSString * _Nullable)SeriesUrn HostName:(NSString * _Nullable)HostName SeriesHostName:(NSString * _Nullable)SeriesHostName PrimaryChannel:(NSString * _Nullable)PrimaryChannel PrimaryChannelSlug:(NSString * _Nullable)PrimaryChannelSlug SeasonEpisodeNumberingValid:(BOOL)SeasonEpisodeNumberingValid SeasonTitle:(NSString * _Nullable)SeasonTitle SeasonSlug:(NSString * _Nullable)SeasonSlug SeasonUrn:(NSString * _Nullable)SeasonUrn SeasonNumber:(int32_t)SeasonNumber PrePremiere:(BOOL)PrePremiere ExpiresSoon:(BOOL)ExpiresSoon OnlineGenreText:(NSString * _Nullable)OnlineGenreText PrimaryAsset:(DrapiPrimaryAsset * _Nullable)PrimaryAsset HasPublicPrimaryAsset:(BOOL)HasPublicPrimaryAsset AssetTargetTypes:(NSString * _Nullable)AssetTargetTypes PrimaryBroadcastStartTime:(DrapiDate * _Nullable)PrimaryBroadcastStartTime SortDateTime:(DrapiDate * _Nullable)SortDateTime OnDemandInfo:(DrapiInfo * _Nullable)OnDemandInfo Slug:(NSString * _Nullable)Slug Urn:(NSString * _Nullable)Urn PrimaryImageUri:(NSString * _Nullable)PrimaryImageUri PresentationUri:(NSString * _Nullable)PresentationUri PresentationUriAutoplay:(NSString * _Nullable)PresentationUriAutoplay Title:(NSString * _Nullable)Title Subtitle:(NSString * _Nullable)Subtitle IsNewSeries:(BOOL)IsNewSeries OriginalTitle:(NSString * _Nullable)OriginalTitle RectificationStatus:(NSString * _Nullable)RectificationStatus RectificationAuto:(BOOL)RectificationAuto RectificationText:(NSString * _Nullable)RectificationText serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:seen2:Type:SeriesTitle:EpisodeTitle:SeriesSlug:SeriesUrn:HostName:SeriesHostName:PrimaryChannel:PrimaryChannelSlug:SeasonEpisodeNumberingValid:SeasonTitle:SeasonSlug:SeasonUrn:SeasonNumber:PrePremiere:ExpiresSoon:OnlineGenreText:PrimaryAsset:HasPublicPrimaryAsset:AssetTargetTypes:PrimaryBroadcastStartTime:SortDateTime:OnDemandInfo:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:Subtitle:IsNewSeries:OriginalTitle:RectificationStatus:RectificationAuto:RectificationText:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithType:(NSString *)Type SeriesTitle:(NSString *)SeriesTitle EpisodeTitle:(NSString *)EpisodeTitle SeriesSlug:(NSString *)SeriesSlug SeriesUrn:(NSString *)SeriesUrn HostName:(NSString *)HostName SeriesHostName:(NSString *)SeriesHostName PrimaryChannel:(NSString *)PrimaryChannel PrimaryChannelSlug:(NSString *)PrimaryChannelSlug SeasonEpisodeNumberingValid:(BOOL)SeasonEpisodeNumberingValid SeasonTitle:(NSString * _Nullable)SeasonTitle SeasonSlug:(NSString * _Nullable)SeasonSlug SeasonUrn:(NSString * _Nullable)SeasonUrn SeasonNumber:(int32_t)SeasonNumber PrePremiere:(BOOL)PrePremiere ExpiresSoon:(BOOL)ExpiresSoon OnlineGenreText:(NSString *)OnlineGenreText PrimaryAsset:(DrapiPrimaryAsset * _Nullable)PrimaryAsset HasPublicPrimaryAsset:(BOOL)HasPublicPrimaryAsset AssetTargetTypes:(NSString *)AssetTargetTypes PrimaryBroadcastStartTime:(DrapiDate * _Nullable)PrimaryBroadcastStartTime SortDateTime:(DrapiDate *)SortDateTime OnDemandInfo:(DrapiInfo * _Nullable)OnDemandInfo Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title Subtitle:(NSString *)Subtitle IsNewSeries:(BOOL)IsNewSeries OriginalTitle:(NSString *)OriginalTitle RectificationStatus:(NSString *)RectificationStatus RectificationAuto:(BOOL)RectificationAuto RectificationText:(NSString *)RectificationText __attribute__((swift_name("init(Type:SeriesTitle:EpisodeTitle:SeriesSlug:SeriesUrn:HostName:SeriesHostName:PrimaryChannel:PrimaryChannelSlug:SeasonEpisodeNumberingValid:SeasonTitle:SeasonSlug:SeasonUrn:SeasonNumber:PrePremiere:ExpiresSoon:OnlineGenreText:PrimaryAsset:HasPublicPrimaryAsset:AssetTargetTypes:PrimaryBroadcastStartTime:SortDateTime:OnDemandInfo:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:Subtitle:IsNewSeries:OriginalTitle:RectificationStatus:RectificationAuto:RectificationText:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (NSString *)component6 __attribute__((swift_name("component6()")));
- (NSString *)component7 __attribute__((swift_name("component7()")));
- (NSString *)component8 __attribute__((swift_name("component8()")));
- (NSString *)component9 __attribute__((swift_name("component9()")));
- (BOOL)component10 __attribute__((swift_name("component10()")));
- (NSString * _Nullable)component11 __attribute__((swift_name("component11()")));
- (NSString * _Nullable)component12 __attribute__((swift_name("component12()")));
- (NSString * _Nullable)component13 __attribute__((swift_name("component13()")));
- (int32_t)component14 __attribute__((swift_name("component14()")));
- (BOOL)component15 __attribute__((swift_name("component15()")));
- (BOOL)component16 __attribute__((swift_name("component16()")));
- (NSString *)component17 __attribute__((swift_name("component17()")));
- (DrapiPrimaryAsset * _Nullable)component18 __attribute__((swift_name("component18()")));
- (BOOL)component19 __attribute__((swift_name("component19()")));
- (NSString *)component20 __attribute__((swift_name("component20()")));
- (DrapiDate * _Nullable)component21 __attribute__((swift_name("component21()")));
- (DrapiDate *)component22 __attribute__((swift_name("component22()")));
- (DrapiInfo * _Nullable)component23 __attribute__((swift_name("component23()")));
- (NSString *)component24 __attribute__((swift_name("component24()")));
- (NSString *)component25 __attribute__((swift_name("component25()")));
- (NSString *)component26 __attribute__((swift_name("component26()")));
- (NSString *)component27 __attribute__((swift_name("component27()")));
- (NSString *)component28 __attribute__((swift_name("component28()")));
- (NSString *)component29 __attribute__((swift_name("component29()")));
- (NSString *)component30 __attribute__((swift_name("component30()")));
- (BOOL)component31 __attribute__((swift_name("component31()")));
- (NSString *)component32 __attribute__((swift_name("component32()")));
- (NSString *)component33 __attribute__((swift_name("component33()")));
- (BOOL)component34 __attribute__((swift_name("component34()")));
- (NSString *)component35 __attribute__((swift_name("component35()")));
- (DrapiProgramCard *)doCopyType:(NSString *)Type SeriesTitle:(NSString *)SeriesTitle EpisodeTitle:(NSString *)EpisodeTitle SeriesSlug:(NSString *)SeriesSlug SeriesUrn:(NSString *)SeriesUrn HostName:(NSString *)HostName SeriesHostName:(NSString *)SeriesHostName PrimaryChannel:(NSString *)PrimaryChannel PrimaryChannelSlug:(NSString *)PrimaryChannelSlug SeasonEpisodeNumberingValid:(BOOL)SeasonEpisodeNumberingValid SeasonTitle:(NSString * _Nullable)SeasonTitle SeasonSlug:(NSString * _Nullable)SeasonSlug SeasonUrn:(NSString * _Nullable)SeasonUrn SeasonNumber:(int32_t)SeasonNumber PrePremiere:(BOOL)PrePremiere ExpiresSoon:(BOOL)ExpiresSoon OnlineGenreText:(NSString *)OnlineGenreText PrimaryAsset:(DrapiPrimaryAsset * _Nullable)PrimaryAsset HasPublicPrimaryAsset:(BOOL)HasPublicPrimaryAsset AssetTargetTypes:(NSString *)AssetTargetTypes PrimaryBroadcastStartTime:(DrapiDate * _Nullable)PrimaryBroadcastStartTime SortDateTime:(DrapiDate *)SortDateTime OnDemandInfo:(DrapiInfo * _Nullable)OnDemandInfo Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title Subtitle:(NSString *)Subtitle IsNewSeries:(BOOL)IsNewSeries OriginalTitle:(NSString *)OriginalTitle RectificationStatus:(NSString *)RectificationStatus RectificationAuto:(BOOL)RectificationAuto RectificationText:(NSString *)RectificationText __attribute__((swift_name("doCopy(Type:SeriesTitle:EpisodeTitle:SeriesSlug:SeriesUrn:HostName:SeriesHostName:PrimaryChannel:PrimaryChannelSlug:SeasonEpisodeNumberingValid:SeasonTitle:SeasonSlug:SeasonUrn:SeasonNumber:PrePremiere:ExpiresSoon:OnlineGenreText:PrimaryAsset:HasPublicPrimaryAsset:AssetTargetTypes:PrimaryBroadcastStartTime:SortDateTime:OnDemandInfo:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:Subtitle:IsNewSeries:OriginalTitle:RectificationStatus:RectificationAuto:RectificationText:)")));
@property (readonly) NSString *Type __attribute__((swift_name("Type")));
@property (readonly) NSString *SeriesTitle __attribute__((swift_name("SeriesTitle")));
@property (readonly) NSString *EpisodeTitle __attribute__((swift_name("EpisodeTitle")));
@property (readonly) NSString *SeriesSlug __attribute__((swift_name("SeriesSlug")));
@property (readonly) NSString *SeriesUrn __attribute__((swift_name("SeriesUrn")));
@property (readonly) NSString *HostName __attribute__((swift_name("HostName")));
@property (readonly) NSString *SeriesHostName __attribute__((swift_name("SeriesHostName")));
@property (readonly) NSString *PrimaryChannel __attribute__((swift_name("PrimaryChannel")));
@property (readonly) NSString *PrimaryChannelSlug __attribute__((swift_name("PrimaryChannelSlug")));
@property (readonly) BOOL SeasonEpisodeNumberingValid __attribute__((swift_name("SeasonEpisodeNumberingValid")));
@property (readonly) NSString * _Nullable SeasonTitle __attribute__((swift_name("SeasonTitle")));
@property (readonly) NSString * _Nullable SeasonSlug __attribute__((swift_name("SeasonSlug")));
@property (readonly) NSString * _Nullable SeasonUrn __attribute__((swift_name("SeasonUrn")));
@property (readonly) int32_t SeasonNumber __attribute__((swift_name("SeasonNumber")));
@property (readonly) BOOL PrePremiere __attribute__((swift_name("PrePremiere")));
@property (readonly) BOOL ExpiresSoon __attribute__((swift_name("ExpiresSoon")));
@property (readonly) NSString *OnlineGenreText __attribute__((swift_name("OnlineGenreText")));
@property (readonly) DrapiPrimaryAsset * _Nullable PrimaryAsset __attribute__((swift_name("PrimaryAsset")));
@property (readonly) BOOL HasPublicPrimaryAsset __attribute__((swift_name("HasPublicPrimaryAsset")));
@property (readonly) NSString *AssetTargetTypes __attribute__((swift_name("AssetTargetTypes")));
@property (readonly) DrapiDate * _Nullable PrimaryBroadcastStartTime __attribute__((swift_name("PrimaryBroadcastStartTime")));
@property (readonly) DrapiDate *SortDateTime __attribute__((swift_name("SortDateTime")));
@property (readonly) DrapiInfo * _Nullable OnDemandInfo __attribute__((swift_name("OnDemandInfo")));
@property (readonly) NSString *Slug __attribute__((swift_name("Slug")));
@property (readonly) NSString *Urn __attribute__((swift_name("Urn")));
@property (readonly) NSString *PrimaryImageUri __attribute__((swift_name("PrimaryImageUri")));
@property (readonly) NSString *PresentationUri __attribute__((swift_name("PresentationUri")));
@property (readonly) NSString *PresentationUriAutoplay __attribute__((swift_name("PresentationUriAutoplay")));
@property (readonly) NSString *Title __attribute__((swift_name("Title")));
@property (readonly) NSString *Subtitle __attribute__((swift_name("Subtitle")));
@property (readonly) BOOL IsNewSeries __attribute__((swift_name("IsNewSeries")));
@property (readonly) NSString *OriginalTitle __attribute__((swift_name("OriginalTitle")));
@property (readonly) NSString *RectificationStatus __attribute__((swift_name("RectificationStatus")));
@property (readonly) BOOL RectificationAuto __attribute__((swift_name("RectificationAuto")));
@property (readonly) NSString *RectificationText __attribute__((swift_name("RectificationText")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProgramCard.Companion")))
@interface DrapiProgramCardCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProgramCard.$serializer")))
@interface DrapiProgramCard$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiProgramCard *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiProgramCard *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiProgramCard *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiProgramCard *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Info")))
@interface DrapiInfo : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 StartPublish:(DrapiDate * _Nullable)StartPublish EndPublish:(DrapiDate * _Nullable)EndPublish serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:StartPublish:EndPublish:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithStartPublish:(DrapiDate *)StartPublish EndPublish:(DrapiDate *)EndPublish __attribute__((swift_name("init(StartPublish:EndPublish:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (DrapiDate *)component1 __attribute__((swift_name("component1()")));
- (DrapiDate *)component2 __attribute__((swift_name("component2()")));
- (DrapiInfo *)doCopyStartPublish:(DrapiDate *)StartPublish EndPublish:(DrapiDate *)EndPublish __attribute__((swift_name("doCopy(StartPublish:EndPublish:)")));
@property (readonly) DrapiDate *StartPublish __attribute__((swift_name("StartPublish")));
@property (readonly) DrapiDate *EndPublish __attribute__((swift_name("EndPublish")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Info.Companion")))
@interface DrapiInfoCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Info.$serializer")))
@interface DrapiInfo$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiInfo *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiInfo *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiInfo *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiInfo *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PrimaryAsset")))
@interface DrapiPrimaryAsset : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Kind:(NSString * _Nullable)Kind Uri:(NSString * _Nullable)Uri DurationInMilliseconds:(int64_t)DurationInMilliseconds Downloadable:(BOOL)Downloadable RestrictedToDenmark:(BOOL)RestrictedToDenmark StartPublish:(DrapiDate * _Nullable)StartPublish EndPublish:(DrapiDate * _Nullable)EndPublish Target:(NSString * _Nullable)Target Encrypted:(BOOL)Encrypted IsLiveStream:(BOOL)IsLiveStream serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Kind:Uri:DurationInMilliseconds:Downloadable:RestrictedToDenmark:StartPublish:EndPublish:Target:Encrypted:IsLiveStream:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithKind:(NSString *)Kind Uri:(NSString *)Uri DurationInMilliseconds:(int64_t)DurationInMilliseconds Downloadable:(BOOL)Downloadable RestrictedToDenmark:(BOOL)RestrictedToDenmark StartPublish:(DrapiDate *)StartPublish EndPublish:(DrapiDate *)EndPublish Target:(NSString *)Target Encrypted:(BOOL)Encrypted IsLiveStream:(BOOL)IsLiveStream __attribute__((swift_name("init(Kind:Uri:DurationInMilliseconds:Downloadable:RestrictedToDenmark:StartPublish:EndPublish:Target:Encrypted:IsLiveStream:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (int64_t)component3 __attribute__((swift_name("component3()")));
- (BOOL)component4 __attribute__((swift_name("component4()")));
- (BOOL)component5 __attribute__((swift_name("component5()")));
- (DrapiDate *)component6 __attribute__((swift_name("component6()")));
- (DrapiDate *)component7 __attribute__((swift_name("component7()")));
- (NSString *)component8 __attribute__((swift_name("component8()")));
- (BOOL)component9 __attribute__((swift_name("component9()")));
- (BOOL)component10 __attribute__((swift_name("component10()")));
- (DrapiPrimaryAsset *)doCopyKind:(NSString *)Kind Uri:(NSString *)Uri DurationInMilliseconds:(int64_t)DurationInMilliseconds Downloadable:(BOOL)Downloadable RestrictedToDenmark:(BOOL)RestrictedToDenmark StartPublish:(DrapiDate *)StartPublish EndPublish:(DrapiDate *)EndPublish Target:(NSString *)Target Encrypted:(BOOL)Encrypted IsLiveStream:(BOOL)IsLiveStream __attribute__((swift_name("doCopy(Kind:Uri:DurationInMilliseconds:Downloadable:RestrictedToDenmark:StartPublish:EndPublish:Target:Encrypted:IsLiveStream:)")));
@property (readonly) NSString *Kind __attribute__((swift_name("Kind")));
@property (readonly) NSString *Uri __attribute__((swift_name("Uri")));
@property (readonly) int64_t DurationInMilliseconds __attribute__((swift_name("DurationInMilliseconds")));
@property (readonly) BOOL Downloadable __attribute__((swift_name("Downloadable")));
@property (readonly) BOOL RestrictedToDenmark __attribute__((swift_name("RestrictedToDenmark")));
@property (readonly) DrapiDate *StartPublish __attribute__((swift_name("StartPublish")));
@property (readonly) DrapiDate *EndPublish __attribute__((swift_name("EndPublish")));
@property (readonly) NSString *Target __attribute__((swift_name("Target")));
@property (readonly) BOOL Encrypted __attribute__((swift_name("Encrypted")));
@property (readonly) BOOL IsLiveStream __attribute__((swift_name("IsLiveStream")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PrimaryAsset.Companion")))
@interface DrapiPrimaryAssetCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PrimaryAsset.$serializer")))
@interface DrapiPrimaryAsset$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiPrimaryAsset *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiPrimaryAsset *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiPrimaryAsset *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiPrimaryAsset *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Manifest")))
@interface DrapiManifest : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Links:(NSArray<DrapiLink *> * _Nullable)Links SubtitlesList:(NSArray<DrapiSubtitle *> * _Nullable)SubtitlesList serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Links:SubtitlesList:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithLinks:(NSArray<DrapiLink *> *)Links SubtitlesList:(NSArray<DrapiSubtitle *> *)SubtitlesList __attribute__((swift_name("init(Links:SubtitlesList:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getEncryptedUri __attribute__((swift_name("getEncryptedUri()")));
- (NSString * _Nullable)getUri __attribute__((swift_name("getUri()")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSArray<DrapiLink *> *)component1 __attribute__((swift_name("component1()")));
- (NSArray<DrapiSubtitle *> *)component2 __attribute__((swift_name("component2()")));
- (DrapiManifest *)doCopyLinks:(NSArray<DrapiLink *> *)Links SubtitlesList:(NSArray<DrapiSubtitle *> *)SubtitlesList __attribute__((swift_name("doCopy(Links:SubtitlesList:)")));
@property (readonly) NSArray<DrapiLink *> *Links __attribute__((swift_name("Links")));
@property (readonly) NSArray<DrapiSubtitle *> *SubtitlesList __attribute__((swift_name("SubtitlesList")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Manifest.Companion")))
@interface DrapiManifestCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Manifest.$serializer")))
@interface DrapiManifest$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiManifest *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiManifest *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiManifest *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiManifest *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Link")))
@interface DrapiLink : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 HardSubtitlesType:(NSString * _Nullable)HardSubtitlesType Uri:(NSString * _Nullable)Uri EncryptedUri:(NSString * _Nullable)EncryptedUri FileFormat:(NSString * _Nullable)FileFormat Target:(NSString * _Nullable)Target Bitrate:(int32_t)Bitrate serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:HardSubtitlesType:Uri:EncryptedUri:FileFormat:Target:Bitrate:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithHardSubtitlesType:(NSString *)HardSubtitlesType Uri:(NSString * _Nullable)Uri EncryptedUri:(NSString *)EncryptedUri FileFormat:(NSString *)FileFormat Target:(NSString *)Target Bitrate:(int32_t)Bitrate __attribute__((swift_name("init(HardSubtitlesType:Uri:EncryptedUri:FileFormat:Target:Bitrate:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (int32_t)component6 __attribute__((swift_name("component6()")));
- (DrapiLink *)doCopyHardSubtitlesType:(NSString *)HardSubtitlesType Uri:(NSString * _Nullable)Uri EncryptedUri:(NSString *)EncryptedUri FileFormat:(NSString *)FileFormat Target:(NSString *)Target Bitrate:(int32_t)Bitrate __attribute__((swift_name("doCopy(HardSubtitlesType:Uri:EncryptedUri:FileFormat:Target:Bitrate:)")));
@property (readonly) NSString *HardSubtitlesType __attribute__((swift_name("HardSubtitlesType")));
@property (readonly) NSString * _Nullable Uri __attribute__((swift_name("Uri")));
@property (readonly) NSString *EncryptedUri __attribute__((swift_name("EncryptedUri")));
@property (readonly) NSString *FileFormat __attribute__((swift_name("FileFormat")));
@property (readonly) NSString *Target __attribute__((swift_name("Target")));
@property (readonly) int32_t Bitrate __attribute__((swift_name("Bitrate")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Link.Companion")))
@interface DrapiLinkCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Link.$serializer")))
@interface DrapiLink$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiLink *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiLink *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiLink *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiLink *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Subtitle")))
@interface DrapiSubtitle : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Language:(NSString * _Nullable)Language MimeType:(NSString * _Nullable)MimeType Type:(NSString * _Nullable)Type Uri:(NSString * _Nullable)Uri serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Language:MimeType:Type:Uri:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithLanguage:(NSString *)Language MimeType:(NSString *)MimeType Type:(NSString *)Type Uri:(NSString *)Uri __attribute__((swift_name("init(Language:MimeType:Type:Uri:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (DrapiSubtitle *)doCopyLanguage:(NSString *)Language MimeType:(NSString *)MimeType Type:(NSString *)Type Uri:(NSString *)Uri __attribute__((swift_name("doCopy(Language:MimeType:Type:Uri:)")));
@property (readonly) NSString *Language __attribute__((swift_name("Language")));
@property (readonly) NSString *MimeType __attribute__((swift_name("MimeType")));
@property (readonly) NSString *Type __attribute__((swift_name("Type")));
@property (readonly) NSString *Uri __attribute__((swift_name("Uri")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Subtitle.Companion")))
@interface DrapiSubtitleCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Subtitle.$serializer")))
@interface DrapiSubtitle$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiSubtitle *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiSubtitle *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiSubtitle *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiSubtitle *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MostViewed")))
@interface DrapiMostViewed : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Items:(NSArray<DrapiProgramCard *> * _Nullable)Items Paging:(DrapiMuPaging * _Nullable)Paging TotalSize:(int32_t)TotalSize serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Items:Paging:TotalSize:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithItems:(NSArray<DrapiProgramCard *> *)Items Paging:(DrapiMuPaging *)Paging TotalSize:(int32_t)TotalSize __attribute__((swift_name("init(Items:Paging:TotalSize:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSArray<DrapiProgramCard *> *)component1 __attribute__((swift_name("component1()")));
- (DrapiMuPaging *)component2 __attribute__((swift_name("component2()")));
- (int32_t)component3 __attribute__((swift_name("component3()")));
- (DrapiMostViewed *)doCopyItems:(NSArray<DrapiProgramCard *> *)Items Paging:(DrapiMuPaging *)Paging TotalSize:(int32_t)TotalSize __attribute__((swift_name("doCopy(Items:Paging:TotalSize:)")));
@property (readonly) NSArray<DrapiProgramCard *> *Items __attribute__((swift_name("Items")));
@property (readonly) DrapiMuPaging *Paging __attribute__((swift_name("Paging")));
@property (readonly) int32_t TotalSize __attribute__((swift_name("TotalSize")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MostViewed.Companion")))
@interface DrapiMostViewedCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MostViewed.$serializer")))
@interface DrapiMostViewed$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiMostViewed *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMostViewed *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiMostViewed *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiMostViewed *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Programs")))
@interface DrapiPrograms : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Items:(NSArray<DrapiProgramCard *> * _Nullable)Items Paging:(DrapiMuPaging * _Nullable)Paging TotalSize:(int32_t)TotalSize serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Items:Paging:TotalSize:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithItems:(NSArray<DrapiProgramCard *> *)Items Paging:(DrapiMuPaging *)Paging TotalSize:(int32_t)TotalSize __attribute__((swift_name("init(Items:Paging:TotalSize:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSArray<DrapiProgramCard *> *)component1 __attribute__((swift_name("component1()")));
- (DrapiMuPaging *)component2 __attribute__((swift_name("component2()")));
- (int32_t)component3 __attribute__((swift_name("component3()")));
- (DrapiPrograms *)doCopyItems:(NSArray<DrapiProgramCard *> *)Items Paging:(DrapiMuPaging *)Paging TotalSize:(int32_t)TotalSize __attribute__((swift_name("doCopy(Items:Paging:TotalSize:)")));
@property (readonly) NSArray<DrapiProgramCard *> *Items __attribute__((swift_name("Items")));
@property (readonly) DrapiMuPaging *Paging __attribute__((swift_name("Paging")));
@property (readonly) int32_t TotalSize __attribute__((swift_name("TotalSize")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Programs.Companion")))
@interface DrapiProgramsCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Programs.$serializer")))
@interface DrapiPrograms$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiPrograms *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiPrograms *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiPrograms *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiPrograms *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Page")))
@interface DrapiPage : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Programs:(DrapiPrograms * _Nullable)Programs serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Programs:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPrograms:(DrapiPrograms *)Programs __attribute__((swift_name("init(Programs:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (DrapiPrograms *)component1 __attribute__((swift_name("component1()")));
- (DrapiPage *)doCopyPrograms:(DrapiPrograms *)Programs __attribute__((swift_name("doCopy(Programs:)")));
@property (readonly) DrapiPrograms *Programs __attribute__((swift_name("Programs")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Page.Companion")))
@interface DrapiPageCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Page.$serializer")))
@interface DrapiPage$serializer : KotlinBase <DrapiKotlinx_serialization_runtimeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)childSerializers __attribute__((swift_name("childSerializers()")));
- (DrapiPage *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiPage *)patchDecoder:(id<DrapiKotlinx_serialization_runtimeDecoder>)decoder old:(DrapiPage *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtimeEncoder>)encoder obj:(DrapiPage *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Genre")))
@interface DrapiGenre : KotlinBase
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Genre.Drama")))
@interface DrapiGenreDrama : DrapiGenre
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)drama __attribute__((swift_name("init()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Genre.Dokumentar")))
@interface DrapiGenreDokumentar : DrapiGenre
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)dokumentar __attribute__((swift_name("init()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Genre.Livsstil")))
@interface DrapiGenreLivsstil : DrapiGenre
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)livsstil __attribute__((swift_name("init()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Genre.Kultur")))
@interface DrapiGenreKultur : DrapiGenre
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)kultur __attribute__((swift_name("init()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Genre.NaturViden")))
@interface DrapiGenreNaturViden : DrapiGenre
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)naturViden __attribute__((swift_name("init()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Genre.NyhederAktualitet")))
@interface DrapiGenreNyhederAktualitet : DrapiGenre
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)nyhederAktualitet __attribute__((swift_name("init()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Genre.Sport")))
@interface DrapiGenreSport : DrapiGenre
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)sport __attribute__((swift_name("init()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Genre.Underholdning")))
@interface DrapiGenreUnderholdning : DrapiGenre
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)underholdning __attribute__((swift_name("init()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Genre.Companion")))
@interface DrapiGenreCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (DrapiGenre *)getByValueValue:(NSString *)value __attribute__((swift_name("getByValue(value:)")));
@end;

__attribute__((swift_name("DrMuRepository")))
@interface DrapiDrMuRepository : KotlinBase
- (instancetype)initWithCacheDir:(NSString * _Nullable)cacheDir sizeBytes:(int64_t)sizeBytes __attribute__((swift_name("init(cacheDir:sizeBytes:)"))) __attribute__((objc_designated_initializer));
- (BOOL)equalsOther:(id _Nullable)other __attribute__((swift_name("equals(other:)")));
- (int32_t)hashCode __attribute__((swift_name("hashCode()")));
- (NSString *)toString __attribute__((swift_name("toString()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HttpClientFactory")))
@interface DrapiHttpClientFactory : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)httpClientFactory __attribute__((swift_name("init()")));
- (DrapiKtor_client_coreHttpClient *)createCacheDir:(NSString * _Nullable)cacheDir sizeBytes:(int64_t)sizeBytes __attribute__((swift_name("create(cacheDir:sizeBytes:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineScope")))
@protocol DrapiKotlinx_coroutines_coreCoroutineScope
@required
@property (readonly) id<DrapiKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrMuRepositoryCallback")))
@interface DrapiDrMuRepositoryCallback : DrapiDrMuRepository <DrapiKotlinx_coroutines_coreCoroutineScope>
- (instancetype)initWithCoroutineContext:(id<DrapiKotlinCoroutineContext>)coroutineContext __attribute__((swift_name("init(coroutineContext:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCacheDir:(NSString * _Nullable)cacheDir sizeBytes:(int64_t)sizeBytes __attribute__((swift_name("init(cacheDir:sizeBytes:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (id<DrapiKotlinx_coroutines_coreJob>)getAllActiveDrTvChannelsCallback:(void (^)(NSArray<DrapiChannel *> *))callback __attribute__((swift_name("getAllActiveDrTvChannels(callback:)")));
- (id<DrapiKotlinx_coroutines_coreJob>)getManifestUri:(NSString *)uri callback:(void (^)(DrapiManifest *))callback __attribute__((swift_name("getManifest(uri:callback:)")));
- (id<DrapiKotlinx_coroutines_coreJob>)getScheduleId:(NSString *)id date:(NSString *)date callback:(void (^)(DrapiSchedule *))callback __attribute__((swift_name("getSchedule(id:date:callback:)")));
- (id<DrapiKotlinx_coroutines_coreJob>)getScheduleNowNextId:(NSString *)id callback:(void (^)(DrapiMuNowNext *))callback __attribute__((swift_name("getScheduleNowNext(id:callback:)")));
- (id<DrapiKotlinx_coroutines_coreJob>)getScheduleNowNextCallback:(void (^)(NSArray<DrapiMuNowNext *> *))callback __attribute__((swift_name("getScheduleNowNext(callback:)")));
- (id<DrapiKotlinx_coroutines_coreJob>)searchQuery:(NSString *)query callback:(void (^)(DrapiSearchResult *))callback __attribute__((swift_name("search(query:callback:)")));
- (id<DrapiKotlinx_coroutines_coreJob>)getMostViewedChannel:(NSString *)channel channelType:(NSString *)channelType limit:(int32_t)limit callback:(void (^)(DrapiMostViewed *))callback __attribute__((swift_name("getMostViewed(channel:channelType:limit:callback:)")));
@property (readonly) id<DrapiKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrMuApiKt")))
@interface DrapiDrMuApiKt : KotlinBase
@property (class, readonly) NSString *API_VERSION __attribute__((swift_name("API_VERSION")));
@property (class, readonly) NSString *API_URL __attribute__((swift_name("API_URL")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrMuRepositoryKt")))
@interface DrapiDrMuRepositoryKt : KotlinBase
@property (class, readonly) int64_t defaultCacheSize __attribute__((swift_name("defaultCacheSize")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeEncoder")))
@protocol DrapiKotlinx_serialization_runtimeEncoder
@required
- (id<DrapiKotlinx_serialization_runtimeCompositeEncoder>)beginCollectionDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc collectionSize:(int32_t)collectionSize typeParams:(DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)typeParams __attribute__((swift_name("beginCollection(desc:collectionSize:typeParams:)")));
- (id<DrapiKotlinx_serialization_runtimeCompositeEncoder>)beginStructureDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc typeParams:(DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)typeParams __attribute__((swift_name("beginStructure(desc:typeParams:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescription:(DrapiKotlinx_serialization_runtimeEnumDescriptor *)enumDescription ordinal:(int32_t)ordinal __attribute__((swift_name("encodeEnum(enumDescription:ordinal:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));
- (void)encodeNull __attribute__((swift_name("encodeNull()")));
- (void)encodeNullableSerializableValueSerializer:(id<DrapiKotlinx_serialization_runtimeSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<DrapiKotlinx_serialization_runtimeSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
- (void)encodeUnit __attribute__((swift_name("encodeUnit()")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialModule> context __attribute__((swift_name("context")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeSerialDescriptor")))
@protocol DrapiKotlinx_serialization_runtimeSerialDescriptor
@required
- (NSArray<id<DrapiKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));
- (id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));
- (NSArray<id<DrapiKotlinAnnotation>> *)getEntityAnnotations __attribute__((swift_name("getEntityAnnotations()")));
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));
@property (readonly) DrapiKotlinx_serialization_runtimeSerialKind *kind __attribute__((swift_name("kind")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeDecoder")))
@protocol DrapiKotlinx_serialization_runtimeDecoder
@required
- (id<DrapiKotlinx_serialization_runtimeCompositeDecoder>)beginStructureDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc typeParams:(DrapiKotlinArray<id<DrapiKotlinx_serialization_runtimeKSerializer>> *)typeParams __attribute__((swift_name("beginStructure(desc:typeParams:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescription:(DrapiKotlinx_serialization_runtimeEnumDescriptor *)enumDescription __attribute__((swift_name("decodeEnum(enumDescription:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));
- (DrapiKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<DrapiKotlinx_serialization_runtimeDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<DrapiKotlinx_serialization_runtimeDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
- (void)decodeUnit __attribute__((swift_name("decodeUnit()")));
- (id _Nullable)updateNullableSerializableValueDeserializer:(id<DrapiKotlinx_serialization_runtimeDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateNullableSerializableValue(deserializer:old:)")));
- (id _Nullable)updateSerializableValueDeserializer:(id<DrapiKotlinx_serialization_runtimeDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateSerializableValue(deserializer:old:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialModule> context __attribute__((swift_name("context")));
@property (readonly) DrapiKotlinx_serialization_runtimeUpdateMode *updateMode __attribute__((swift_name("updateMode")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface DrapiKotlinArray<T> : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(DrapiInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<DrapiKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("Kotlinx_ioCloseable")))
@protocol DrapiKotlinx_ioCloseable
@required
- (void)close __attribute__((swift_name("close()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClient")))
@interface DrapiKtor_client_coreHttpClient : KotlinBase <DrapiKotlinx_coroutines_coreCoroutineScope, DrapiKotlinx_ioCloseable>
- (instancetype)initWithEngine:(id<DrapiKtor_client_coreHttpClientEngine>)engine userConfig:(DrapiKtor_client_coreHttpClientConfig<DrapiKtor_client_coreHttpClientEngineConfig *> *)userConfig __attribute__((swift_name("init(engine:userConfig:)"))) __attribute__((objc_designated_initializer));
- (void)close __attribute__((swift_name("close()")));
- (DrapiKtor_client_coreHttpClient *)configBlock:(void (^)(DrapiKtor_client_coreHttpClientConfig<DrapiKtor_client_coreHttpClientEngineConfig *> *))block __attribute__((swift_name("config(block:)")));
@property (readonly) id<DrapiKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) id<DrapiKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@property (readonly) DrapiKotlinx_coroutines_coreCoroutineDispatcher *dispatcher __attribute__((swift_name("dispatcher")));
@property (readonly) id<DrapiKtor_client_coreHttpClientEngine> engine __attribute__((swift_name("engine")));
@property (readonly) DrapiKtor_client_coreHttpClientEngineConfig *engineConfig __attribute__((swift_name("engineConfig")));
@property (readonly) DrapiKtor_client_coreHttpReceivePipeline *receivePipeline __attribute__((swift_name("receivePipeline")));
@property (readonly) DrapiKtor_client_coreHttpRequestPipeline *requestPipeline __attribute__((swift_name("requestPipeline")));
@property (readonly) DrapiKtor_client_coreHttpResponsePipeline *responsePipeline __attribute__((swift_name("responsePipeline")));
@property (readonly) DrapiKtor_client_coreHttpSendPipeline *sendPipeline __attribute__((swift_name("sendPipeline")));
@end;

__attribute__((swift_name("KotlinCoroutineContext")))
@protocol DrapiKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<DrapiKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<DrapiKotlinCoroutineContextElement> _Nullable)getKey:(id<DrapiKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<DrapiKotlinCoroutineContext>)minusKeyKey:(id<DrapiKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<DrapiKotlinCoroutineContext>)plusContext:(id<DrapiKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end;

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol DrapiKotlinCoroutineContextElement <DrapiKotlinCoroutineContext>
@required
@property (readonly) id<DrapiKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreJob")))
@protocol DrapiKotlinx_coroutines_coreJob <DrapiKotlinCoroutineContextElement>
@required
- (id<DrapiKotlinx_coroutines_coreChildHandle>)attachChildChild:(id<DrapiKotlinx_coroutines_coreChildJob>)child __attribute__((swift_name("attachChild(child:)")));
- (void)cancel __attribute__((swift_name("cancel()")));
- (BOOL)cancelCause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("cancel(cause:)")));
- (void)cancelCause_:(DrapiKotlinx_coroutines_coreCancellationException * _Nullable)cause __attribute__((swift_name("cancel(cause_:)")));
- (DrapiKotlinx_coroutines_coreCancellationException *)getCancellationException __attribute__((swift_name("getCancellationException()")));
- (id<DrapiKotlinx_coroutines_coreDisposableHandle>)invokeOnCompletionOnCancelling:(BOOL)onCancelling invokeImmediately:(BOOL)invokeImmediately handler:(void (^)(DrapiKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(onCancelling:invokeImmediately:handler:)")));
- (id<DrapiKotlinx_coroutines_coreDisposableHandle>)invokeOnCompletionHandler:(void (^)(DrapiKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(handler:)")));
- (id<DrapiKotlinx_coroutines_coreJob>)plusOther:(id<DrapiKotlinx_coroutines_coreJob>)other __attribute__((swift_name("plus(other:)")));
- (BOOL)start __attribute__((swift_name("start()")));
@property (readonly) id<DrapiKotlinSequence> children __attribute__((swift_name("children")));
@property (readonly) BOOL isActive __attribute__((swift_name("isActive")));
@property (readonly) BOOL isCancelled __attribute__((swift_name("isCancelled")));
@property (readonly) BOOL isCompleted __attribute__((swift_name("isCompleted")));
@property (readonly) id<DrapiKotlinx_coroutines_coreSelectClause0> onJoin __attribute__((swift_name("onJoin")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeCompositeEncoder")))
@protocol DrapiKotlinx_serialization_runtimeCompositeEncoder
@required
- (void)encodeBooleanElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(desc:index:value:)")));
- (void)encodeByteElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(desc:index:value:)")));
- (void)encodeCharElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(desc:index:value:)")));
- (void)encodeDoubleElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(desc:index:value:)")));
- (void)encodeFloatElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(desc:index:value:)")));
- (void)encodeIntElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(desc:index:value:)")));
- (void)encodeLongElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(desc:index:value:)")));
- (void)encodeNonSerializableElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index value:(id)value __attribute__((swift_name("encodeNonSerializableElement(desc:index:value:)")));
- (void)encodeNullableSerializableElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index serializer:(id<DrapiKotlinx_serialization_runtimeSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(desc:index:serializer:value:)")));
- (void)encodeSerializableElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index serializer:(id<DrapiKotlinx_serialization_runtimeSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(desc:index:serializer:value:)")));
- (void)encodeShortElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(desc:index:value:)")));
- (void)encodeStringElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(desc:index:value:)")));
- (void)encodeUnitElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("encodeUnitElement(desc:index:)")));
- (void)endStructureDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc __attribute__((swift_name("endStructure(desc:)")));
- (BOOL)shouldEncodeElementDefaultDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(desc:index:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialModule> context __attribute__((swift_name("context")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeSerialClassDescImpl")))
@interface DrapiKotlinx_serialization_runtimeSerialClassDescImpl : KotlinBase <DrapiKotlinx_serialization_runtimeSerialDescriptor>
- (instancetype)initWithName:(NSString *)name generatedSerializer:(id<DrapiKotlinx_serialization_runtimeGeneratedSerializer> _Nullable)generatedSerializer __attribute__((swift_name("init(name:generatedSerializer:)"))) __attribute__((objc_designated_initializer));
- (void)addElementName:(NSString *)name isOptional:(BOOL)isOptional __attribute__((swift_name("addElement(name:isOptional:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSArray<id<DrapiKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));
- (id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));
- (NSArray<id<DrapiKotlinAnnotation>> *)getEntityAnnotations __attribute__((swift_name("getEntityAnnotations()")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));
- (void)pushAnnotationA:(id<DrapiKotlinAnnotation>)a __attribute__((swift_name("pushAnnotation(a:)")));
- (void)pushClassAnnotationA:(id<DrapiKotlinAnnotation>)a __attribute__((swift_name("pushClassAnnotation(a:)")));
- (void)pushDescriptorDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc __attribute__((swift_name("pushDescriptor(desc:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) DrapiKotlinx_serialization_runtimeSerialKind *kind __attribute__((swift_name("kind")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_runtimeEnumDescriptor")))
@interface DrapiKotlinx_serialization_runtimeEnumDescriptor : DrapiKotlinx_serialization_runtimeSerialClassDescImpl
- (instancetype)initWithName:(NSString *)name choices:(DrapiKotlinArray<NSString *> *)choices __attribute__((swift_name("init(name:choices:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithName:(NSString *)name generatedSerializer:(id<DrapiKotlinx_serialization_runtimeGeneratedSerializer> _Nullable)generatedSerializer __attribute__((swift_name("init(name:generatedSerializer:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
@property (readonly) DrapiKotlinx_serialization_runtimeSerialKind *kind __attribute__((swift_name("kind")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeSerialModule")))
@protocol DrapiKotlinx_serialization_runtimeSerialModule
@required
- (void)dumpToCollector:(id<DrapiKotlinx_serialization_runtimeSerialModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer> _Nullable)getContextualKclass:(id<DrapiKotlinKClass>)kclass __attribute__((swift_name("getContextual(kclass:)")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer> _Nullable)getPolymorphicBaseClass:(id<DrapiKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));
- (id<DrapiKotlinx_serialization_runtimeKSerializer> _Nullable)getPolymorphicBaseClass:(id<DrapiKotlinKClass>)baseClass serializedClassName:(NSString *)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end;

__attribute__((swift_name("KotlinAnnotation")))
@protocol DrapiKotlinAnnotation
@required
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeSerialKind")))
@interface DrapiKotlinx_serialization_runtimeSerialKind : KotlinBase
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeCompositeDecoder")))
@protocol DrapiKotlinx_serialization_runtimeCompositeDecoder
@required
- (BOOL)decodeBooleanElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(desc:index:)")));
- (int8_t)decodeByteElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeByteElement(desc:index:)")));
- (unichar)decodeCharElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeCharElement(desc:index:)")));
- (int32_t)decodeCollectionSizeDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc __attribute__((swift_name("decodeCollectionSize(desc:)")));
- (double)decodeDoubleElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(desc:index:)")));
- (int32_t)decodeElementIndexDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc __attribute__((swift_name("decodeElementIndex(desc:)")));
- (float)decodeFloatElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeFloatElement(desc:index:)")));
- (int32_t)decodeIntElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeIntElement(desc:index:)")));
- (int64_t)decodeLongElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeLongElement(desc:index:)")));
- (id _Nullable)decodeNullableSerializableElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index deserializer:(id<DrapiKotlinx_serialization_runtimeDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableElement(desc:index:deserializer:)")));
- (id _Nullable)decodeSerializableElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index deserializer:(id<DrapiKotlinx_serialization_runtimeDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableElement(desc:index:deserializer:)")));
- (int16_t)decodeShortElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeShortElement(desc:index:)")));
- (NSString *)decodeStringElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeStringElement(desc:index:)")));
- (void)decodeUnitElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeUnitElement(desc:index:)")));
- (void)endStructureDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc __attribute__((swift_name("endStructure(desc:)")));
- (id _Nullable)updateNullableSerializableElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index deserializer:(id<DrapiKotlinx_serialization_runtimeDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateNullableSerializableElement(desc:index:deserializer:old:)")));
- (id _Nullable)updateSerializableElementDesc:(id<DrapiKotlinx_serialization_runtimeSerialDescriptor>)desc index:(int32_t)index deserializer:(id<DrapiKotlinx_serialization_runtimeDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateSerializableElement(desc:index:deserializer:old:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtimeSerialModule> context __attribute__((swift_name("context")));
@property (readonly) DrapiKotlinx_serialization_runtimeUpdateMode *updateMode __attribute__((swift_name("updateMode")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface DrapiKotlinNothing : KotlinBase
@end;

__attribute__((swift_name("KotlinComparable")))
@protocol DrapiKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end;

__attribute__((swift_name("KotlinEnum")))
@interface DrapiKotlinEnum<E> : KotlinBase <DrapiKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_runtimeUpdateMode")))
@interface DrapiKotlinx_serialization_runtimeUpdateMode : DrapiKotlinEnum<DrapiKotlinx_serialization_runtimeUpdateMode *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
@property (class, readonly) DrapiKotlinx_serialization_runtimeUpdateMode *banned __attribute__((swift_name("banned")));
@property (class, readonly) DrapiKotlinx_serialization_runtimeUpdateMode *overwrite __attribute__((swift_name("overwrite")));
@property (class, readonly) DrapiKotlinx_serialization_runtimeUpdateMode *update __attribute__((swift_name("update")));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (int32_t)compareToOther:(DrapiKotlinx_serialization_runtimeUpdateMode *)other __attribute__((swift_name("compareTo(other:)")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol DrapiKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientEngine")))
@protocol DrapiKtor_client_coreHttpClientEngine <DrapiKotlinx_coroutines_coreCoroutineScope, DrapiKotlinx_ioCloseable>
@required
- (void)installClient:(DrapiKtor_client_coreHttpClient *)client __attribute__((swift_name("install(client:)")));
@property (readonly) DrapiKtor_client_coreHttpClientEngineConfig *config __attribute__((swift_name("config")));
@property (readonly) DrapiKotlinx_coroutines_coreCoroutineDispatcher *dispatcher __attribute__((swift_name("dispatcher")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientEngineConfig")))
@interface DrapiKtor_client_coreHttpClientEngineConfig : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property DrapiKotlinx_coroutines_coreCoroutineDispatcher * _Nullable dispatcher __attribute__((swift_name("dispatcher")));
@property BOOL pipelining __attribute__((swift_name("pipelining")));
@property (readonly) DrapiKtor_client_coreHttpResponseConfig *response __attribute__((swift_name("response")));
@property int32_t threadsCount __attribute__((swift_name("threadsCount")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClientConfig")))
@interface DrapiKtor_client_coreHttpClientConfig<T> : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (DrapiKtor_client_coreHttpClientConfig<T> *)clone __attribute__((swift_name("clone()")));
- (void)engineBlock:(void (^)(T))block __attribute__((swift_name("engine(block:)")));
- (void)installClient:(DrapiKtor_client_coreHttpClient *)client __attribute__((swift_name("install(client:)")));
- (void)installFeature:(id<DrapiKtor_client_coreHttpClientFeature>)feature configure:(void (^)(id))configure __attribute__((swift_name("install(feature:configure:)")));
- (void)installKey:(NSString *)key block:(void (^)(DrapiKtor_client_coreHttpClient *))block __attribute__((swift_name("install(key:block:)")));
- (void)plusAssignOther:(DrapiKtor_client_coreHttpClientConfig<T> *)other __attribute__((swift_name("plusAssign(other:)")));
@property BOOL expectSuccess __attribute__((swift_name("expectSuccess")));
@property BOOL followRedirects __attribute__((swift_name("followRedirects")));
@property BOOL useDefaultTransformers __attribute__((swift_name("useDefaultTransformers")));
@end;

__attribute__((swift_name("Ktor_utilsAttributes")))
@protocol DrapiKtor_utilsAttributes
@required
- (id)computeIfAbsentKey:(DrapiKtor_utilsAttributeKey<id> *)key block:(id (^)(void))block __attribute__((swift_name("computeIfAbsent(key:block:)")));
- (BOOL)containsKey:(DrapiKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("contains(key:)")));
- (id)getKey_:(DrapiKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("get(key_:)")));
- (id _Nullable)getOrNullKey:(DrapiKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("getOrNull(key:)")));
- (void)putKey:(DrapiKtor_utilsAttributeKey<id> *)key value:(id)value __attribute__((swift_name("put(key:value:)")));
- (void)removeKey:(DrapiKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("remove(key:)")));
- (id)takeKey:(DrapiKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("take(key:)")));
- (id _Nullable)takeOrNullKey:(DrapiKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("takeOrNull(key:)")));
@property (readonly) NSArray<DrapiKtor_utilsAttributeKey<id> *> *allKeys __attribute__((swift_name("allKeys")));
@end;

__attribute__((swift_name("KotlinAbstractCoroutineContextElement")))
@interface DrapiKotlinAbstractCoroutineContextElement : KotlinBase <DrapiKotlinCoroutineContextElement>
- (instancetype)initWithKey:(id<DrapiKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer));
@property (readonly) id<DrapiKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end;

__attribute__((swift_name("KotlinContinuationInterceptor")))
@protocol DrapiKotlinContinuationInterceptor <DrapiKotlinCoroutineContextElement>
@required
- (id<DrapiKotlinContinuation>)interceptContinuationContinuation:(id<DrapiKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (void)releaseInterceptedContinuationContinuation:(id<DrapiKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineDispatcher")))
@interface DrapiKotlinx_coroutines_coreCoroutineDispatcher : DrapiKotlinAbstractCoroutineContextElement <DrapiKotlinContinuationInterceptor>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithKey:(id<DrapiKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)dispatchContext:(id<DrapiKotlinCoroutineContext>)context block:(id<DrapiKotlinx_coroutines_coreRunnable>)block __attribute__((swift_name("dispatch(context:block:)")));
- (void)dispatchYieldContext:(id<DrapiKotlinCoroutineContext>)context block:(id<DrapiKotlinx_coroutines_coreRunnable>)block __attribute__((swift_name("dispatchYield(context:block:)")));
- (id<DrapiKotlinContinuation>)interceptContinuationContinuation:(id<DrapiKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (BOOL)isDispatchNeededContext:(id<DrapiKotlinCoroutineContext>)context __attribute__((swift_name("isDispatchNeeded(context:)")));
- (DrapiKotlinx_coroutines_coreCoroutineDispatcher *)plusOther_:(DrapiKotlinx_coroutines_coreCoroutineDispatcher *)other __attribute__((swift_name("plus(other_:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("Ktor_utilsPipeline")))
@interface DrapiKtor_utilsPipeline<TSubject, TContext> : KotlinBase
- (instancetype)initWithPhase:(DrapiKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<DrapiKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhases:(DrapiKotlinArray<DrapiKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer));
- (void)addPhasePhase:(DrapiKtor_utilsPipelinePhase *)phase __attribute__((swift_name("addPhase(phase:)")));
- (void)afterIntercepted __attribute__((swift_name("afterIntercepted()")));
- (void)insertPhaseAfterReference:(DrapiKtor_utilsPipelinePhase *)reference phase:(DrapiKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseAfter(reference:phase:)")));
- (void)insertPhaseBeforeReference:(DrapiKtor_utilsPipelinePhase *)reference phase:(DrapiKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseBefore(reference:phase:)")));
- (void)interceptPhase:(DrapiKtor_utilsPipelinePhase *)phase block:(id<DrapiKotlinSuspendFunction2>)block __attribute__((swift_name("intercept(phase:block:)")));
- (void)mergeFrom:(DrapiKtor_utilsPipeline<TSubject, TContext> *)from __attribute__((swift_name("merge(from:)")));
@property (readonly) id<DrapiKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) BOOL isEmpty __attribute__((swift_name("isEmpty")));
@property (readonly) NSArray<DrapiKtor_utilsPipelinePhase *> *items __attribute__((swift_name("items")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpReceivePipeline")))
@interface DrapiKtor_client_coreHttpReceivePipeline : DrapiKtor_utilsPipeline<DrapiKtor_client_coreHttpResponse *, DrapiKtor_client_coreHttpClientCall *>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(DrapiKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<DrapiKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(DrapiKotlinArray<DrapiKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)mergeFrom:(DrapiKtor_utilsPipeline<DrapiKtor_client_coreHttpResponse *, DrapiKtor_client_coreHttpClientCall *> *)from __attribute__((swift_name("merge(from:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestPipeline")))
@interface DrapiKtor_client_coreHttpRequestPipeline : DrapiKtor_utilsPipeline<id, DrapiKtor_client_coreHttpRequestBuilder *>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(DrapiKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<DrapiKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(DrapiKotlinArray<DrapiKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)mergeFrom:(DrapiKtor_utilsPipeline<id, DrapiKtor_client_coreHttpRequestBuilder *> *)from __attribute__((swift_name("merge(from:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponsePipeline")))
@interface DrapiKtor_client_coreHttpResponsePipeline : DrapiKtor_utilsPipeline<DrapiKtor_client_coreHttpResponseContainer *, DrapiKtor_client_coreHttpClientCall *>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(DrapiKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<DrapiKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(DrapiKotlinArray<DrapiKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)mergeFrom:(DrapiKtor_utilsPipeline<DrapiKtor_client_coreHttpResponseContainer *, DrapiKtor_client_coreHttpClientCall *> *)from __attribute__((swift_name("merge(from:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpSendPipeline")))
@interface DrapiKtor_client_coreHttpSendPipeline : DrapiKtor_utilsPipeline<id, DrapiKtor_client_coreHttpRequestBuilder *>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(DrapiKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<DrapiKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(DrapiKotlinArray<DrapiKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)mergeFrom:(DrapiKtor_utilsPipeline<id, DrapiKtor_client_coreHttpRequestBuilder *> *)from __attribute__((swift_name("merge(from:)")));
@end;

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol DrapiKotlinCoroutineContextKey
@required
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreDisposableHandle")))
@protocol DrapiKotlinx_coroutines_coreDisposableHandle
@required
- (void)dispose __attribute__((swift_name("dispose()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreChildHandle")))
@protocol DrapiKotlinx_coroutines_coreChildHandle <DrapiKotlinx_coroutines_coreDisposableHandle>
@required
- (BOOL)childCancelledCause:(DrapiKotlinThrowable *)cause __attribute__((swift_name("childCancelled(cause:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreChildJob")))
@protocol DrapiKotlinx_coroutines_coreChildJob <DrapiKotlinx_coroutines_coreJob>
@required
- (void)parentCancelledParentJob:(id<DrapiKotlinx_coroutines_coreParentJob>)parentJob __attribute__((swift_name("parentCancelled(parentJob:)")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface DrapiKotlinThrowable : KotlinBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (DrapiKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) DrapiKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
@end;

__attribute__((swift_name("KotlinException")))
@interface DrapiKotlinException : DrapiKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinRuntimeException")))
@interface DrapiKotlinRuntimeException : DrapiKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinIllegalStateException")))
@interface DrapiKotlinIllegalStateException : DrapiKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreCancellationException")))
@interface DrapiKotlinx_coroutines_coreCancellationException : DrapiKotlinIllegalStateException
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithCause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinSequence")))
@protocol DrapiKotlinSequence
@required
- (id<DrapiKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSelectClause0")))
@protocol DrapiKotlinx_coroutines_coreSelectClause0
@required
- (void)registerSelectClause0Select:(id<DrapiKotlinx_coroutines_coreSelectInstance>)select block:(id<DrapiKotlinSuspendFunction0>)block __attribute__((swift_name("registerSelectClause0(select:block:)")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtimeSerialModuleCollector")))
@protocol DrapiKotlinx_serialization_runtimeSerialModuleCollector
@required
- (void)contextualKClass:(id<DrapiKotlinKClass>)kClass serializer:(id<DrapiKotlinx_serialization_runtimeKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<DrapiKotlinKClass>)baseClass actualClass:(id<DrapiKotlinKClass>)actualClass actualSerializer:(id<DrapiKotlinx_serialization_runtimeKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
@end;

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol DrapiKotlinKDeclarationContainer
@required
@end;

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol DrapiKotlinKAnnotatedElement
@required
@end;

__attribute__((swift_name("KotlinKClassifier")))
@protocol DrapiKotlinKClassifier
@required
@end;

__attribute__((swift_name("KotlinKClass")))
@protocol DrapiKotlinKClass <DrapiKotlinKDeclarationContainer, DrapiKotlinKAnnotatedElement, DrapiKotlinKClassifier>
@required
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpResponseConfig")))
@interface DrapiKtor_client_coreHttpResponseConfig : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property DrapiKotlinx_ioCharset *defaultCharset __attribute__((swift_name("defaultCharset")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientFeature")))
@protocol DrapiKtor_client_coreHttpClientFeature
@required
- (void)installFeature:(id)feature scope:(DrapiKtor_client_coreHttpClient *)scope __attribute__((swift_name("install(feature:scope:)")));
- (id)prepareBlock:(void (^)(id))block __attribute__((swift_name("prepare(block:)")));
@property (readonly) DrapiKtor_utilsAttributeKey<id> *key __attribute__((swift_name("key")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsAttributeKey")))
@interface DrapiKtor_utilsAttributeKey<T> : KotlinBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((swift_name("KotlinContinuation")))
@protocol DrapiKotlinContinuation
@required
- (void)resumeWithResult:(id _Nullable)result __attribute__((swift_name("resumeWith(result:)")));
@property (readonly) id<DrapiKotlinCoroutineContext> context __attribute__((swift_name("context")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreRunnable")))
@protocol DrapiKotlinx_coroutines_coreRunnable
@required
- (void)run __attribute__((swift_name("run()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsPipelinePhase")))
@interface DrapiKtor_utilsPipelinePhase : KotlinBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((swift_name("KotlinSuspendFunction")))
@protocol DrapiKotlinSuspendFunction
@required
@end;

__attribute__((swift_name("KotlinSuspendFunction2")))
@protocol DrapiKotlinSuspendFunction2 <DrapiKotlinSuspendFunction>
@required
@end;

__attribute__((swift_name("Ktor_httpHttpMessage")))
@protocol DrapiKtor_httpHttpMessage
@required
@property (readonly) id<DrapiKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpResponse")))
@interface DrapiKtor_client_coreHttpResponse : KotlinBase <DrapiKtor_httpHttpMessage, DrapiKotlinx_coroutines_coreCoroutineScope, DrapiKotlinx_ioCloseable>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)close __attribute__((swift_name("close()")));
@property (readonly) DrapiKtor_client_coreHttpClientCall *call __attribute__((swift_name("call")));
@property (readonly) id<DrapiKotlinx_coroutines_ioByteReadChannel> content __attribute__((swift_name("content")));
@property (readonly) id<DrapiKotlinx_coroutines_coreJob> executionContext __attribute__((swift_name("executionContext")));
@property (readonly) DrapiKtor_utilsGMTDate *requestTime __attribute__((swift_name("requestTime")));
@property (readonly) DrapiKtor_utilsGMTDate *responseTime __attribute__((swift_name("responseTime")));
@property (readonly) DrapiKtor_httpHttpStatusCode *status __attribute__((swift_name("status")));
@property (readonly) DrapiKtor_httpHttpProtocolVersion *version __attribute__((swift_name("version")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientCall")))
@interface DrapiKtor_client_coreHttpClientCall : KotlinBase <DrapiKotlinx_coroutines_coreCoroutineScope, DrapiKotlinx_ioCloseable>
- (void)close __attribute__((swift_name("close()")));
@property (readonly) id<DrapiKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) DrapiKtor_client_coreHttpClient *client __attribute__((swift_name("client")));
@property (readonly) id<DrapiKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@property (readonly) id<DrapiKtor_client_coreHttpRequest> request __attribute__((swift_name("request")));
@property (readonly) DrapiKtor_client_coreHttpResponse *response __attribute__((swift_name("response")));
@property (readonly) DrapiKtor_client_coreHttpResponseConfig *responseConfig __attribute__((swift_name("responseConfig")));
@end;

__attribute__((swift_name("Ktor_httpHttpMessageBuilder")))
@protocol DrapiKtor_httpHttpMessageBuilder
@required
@property (readonly) DrapiKtor_httpHeadersBuilder *headers __attribute__((swift_name("headers")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestBuilder")))
@interface DrapiKtor_client_coreHttpRequestBuilder : KotlinBase <DrapiKtor_httpHttpMessageBuilder>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (DrapiKtor_client_coreHttpRequestData *)build __attribute__((swift_name("build()")));
- (void)setAttributesBlock:(void (^)(id<DrapiKtor_utilsAttributes>))block __attribute__((swift_name("setAttributes(block:)")));
- (DrapiKtor_client_coreHttpRequestBuilder *)takeFromBuilder:(DrapiKtor_client_coreHttpRequestBuilder *)builder __attribute__((swift_name("takeFrom(builder:)")));
- (void)urlBlock:(void (^)(DrapiKtor_httpURLBuilder *, DrapiKtor_httpURLBuilder *))block __attribute__((swift_name("url(block:)")));
@property (readonly) id<DrapiKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property id body __attribute__((swift_name("body")));
@property (readonly) id<DrapiKotlinx_coroutines_coreJob> executionContext __attribute__((swift_name("executionContext")));
@property (readonly) DrapiKtor_httpHeadersBuilder *headers __attribute__((swift_name("headers")));
@property DrapiKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) DrapiKtor_httpURLBuilder *url __attribute__((swift_name("url")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponseContainer")))
@interface DrapiKtor_client_coreHttpResponseContainer : KotlinBase
- (instancetype)initWithExpectedType:(DrapiKtor_client_coreTypeInfo *)expectedType response:(id)response __attribute__((swift_name("init(expectedType:response:)"))) __attribute__((objc_designated_initializer));
- (DrapiKtor_client_coreTypeInfo *)component1 __attribute__((swift_name("component1()")));
- (id)component2 __attribute__((swift_name("component2()")));
- (DrapiKtor_client_coreHttpResponseContainer *)doCopyExpectedType:(DrapiKtor_client_coreTypeInfo *)expectedType response:(id)response __attribute__((swift_name("doCopy(expectedType:response:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) DrapiKtor_client_coreTypeInfo *expectedType __attribute__((swift_name("expectedType")));
@property (readonly) id response __attribute__((swift_name("response")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreParentJob")))
@protocol DrapiKotlinx_coroutines_coreParentJob <DrapiKotlinx_coroutines_coreJob>
@required
- (DrapiKotlinThrowable *)getChildJobCancellationCause __attribute__((swift_name("getChildJobCancellationCause()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSelectInstance")))
@protocol DrapiKotlinx_coroutines_coreSelectInstance
@required
- (void)disposeOnSelectHandle:(id<DrapiKotlinx_coroutines_coreDisposableHandle>)handle __attribute__((swift_name("disposeOnSelect(handle:)")));
- (id _Nullable)performAtomicIfNotSelectedDesc:(DrapiKotlinx_coroutines_coreAtomicDesc *)desc __attribute__((swift_name("performAtomicIfNotSelected(desc:)")));
- (id _Nullable)performAtomicTrySelectDesc:(DrapiKotlinx_coroutines_coreAtomicDesc *)desc __attribute__((swift_name("performAtomicTrySelect(desc:)")));
- (void)resumeSelectCancellableWithExceptionException:(DrapiKotlinThrowable *)exception __attribute__((swift_name("resumeSelectCancellableWithException(exception:)")));
- (BOOL)trySelectIdempotent:(id _Nullable)idempotent __attribute__((swift_name("trySelect(idempotent:)")));
@property (readonly) id<DrapiKotlinContinuation> completion __attribute__((swift_name("completion")));
@property (readonly) BOOL isSelected __attribute__((swift_name("isSelected")));
@end;

__attribute__((swift_name("KotlinSuspendFunction0")))
@protocol DrapiKotlinSuspendFunction0 <DrapiKotlinSuspendFunction>
@required
@end;

__attribute__((swift_name("Kotlinx_ioCharset")))
@interface DrapiKotlinx_ioCharset : KotlinBase
- (instancetype)initWith_name:(NSString *)_name __attribute__((swift_name("init(_name:)"))) __attribute__((objc_designated_initializer));
- (DrapiKotlinx_ioCharsetDecoder *)doNewDecoder __attribute__((swift_name("doNewDecoder()")));
- (DrapiKotlinx_ioCharsetEncoder *)doNewEncoder __attribute__((swift_name("doNewEncoder()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("Ktor_utilsStringValues")))
@protocol DrapiKtor_utilsStringValues
@required
- (BOOL)containsName:(NSString *)name __attribute__((swift_name("contains(name:)")));
- (BOOL)containsName:(NSString *)name value:(NSString *)value __attribute__((swift_name("contains(name:value:)")));
- (NSSet<id<DrapiKotlinMapEntry>> *)entries __attribute__((swift_name("entries()")));
- (void)forEachBody:(void (^)(NSString *, NSArray<NSString *> *))body __attribute__((swift_name("forEach(body:)")));
- (NSString * _Nullable)getName:(NSString *)name __attribute__((swift_name("get(name:)")));
- (NSArray<NSString *> * _Nullable)getAllName:(NSString *)name __attribute__((swift_name("getAll(name:)")));
- (BOOL)isEmpty_ __attribute__((swift_name("isEmpty()")));
- (NSSet<NSString *> *)names __attribute__((swift_name("names()")));
@property (readonly) BOOL caseInsensitiveName __attribute__((swift_name("caseInsensitiveName")));
@end;

__attribute__((swift_name("Ktor_httpHeaders")))
@protocol DrapiKtor_httpHeaders <DrapiKtor_utilsStringValues>
@required
@end;

__attribute__((swift_name("Kotlinx_coroutines_ioByteReadChannel")))
@protocol DrapiKotlinx_coroutines_ioByteReadChannel
@required
- (BOOL)cancelCause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("cancel(cause:)")));
- (void)readSessionConsumer:(void (^)(id<DrapiKotlinx_coroutines_ioReadSession>))consumer __attribute__((swift_name("readSession(consumer:)")));
@property (readonly) int32_t availableForRead __attribute__((swift_name("availableForRead")));
@property (readonly) BOOL isClosedForRead __attribute__((swift_name("isClosedForRead")));
@property (readonly) BOOL isClosedForWrite __attribute__((swift_name("isClosedForWrite")));
@property DrapiKotlinx_ioByteOrder *readByteOrder __attribute__((swift_name("readByteOrder")));
@property (readonly) int64_t totalBytesRead __attribute__((swift_name("totalBytesRead")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsGMTDate")))
@interface DrapiKtor_utilsGMTDate : KotlinBase <DrapiKotlinComparable>
- (int32_t)compareToOther:(DrapiKtor_utilsGMTDate *)other __attribute__((swift_name("compareTo(other:)")));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (int32_t)component3 __attribute__((swift_name("component3()")));
- (DrapiKtor_utilsWeekDay *)component4 __attribute__((swift_name("component4()")));
- (int32_t)component5 __attribute__((swift_name("component5()")));
- (int32_t)component6 __attribute__((swift_name("component6()")));
- (DrapiKtor_utilsMonth *)component7 __attribute__((swift_name("component7()")));
- (int32_t)component8 __attribute__((swift_name("component8()")));
- (int64_t)component9 __attribute__((swift_name("component9()")));
- (DrapiKtor_utilsGMTDate *)doCopySeconds:(int32_t)seconds minutes:(int32_t)minutes hours:(int32_t)hours dayOfWeek:(DrapiKtor_utilsWeekDay *)dayOfWeek dayOfMonth:(int32_t)dayOfMonth dayOfYear:(int32_t)dayOfYear month:(DrapiKtor_utilsMonth *)month year:(int32_t)year timestamp:(int64_t)timestamp __attribute__((swift_name("doCopy(seconds:minutes:hours:dayOfWeek:dayOfMonth:dayOfYear:month:year:timestamp:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t dayOfMonth __attribute__((swift_name("dayOfMonth")));
@property (readonly) DrapiKtor_utilsWeekDay *dayOfWeek __attribute__((swift_name("dayOfWeek")));
@property (readonly) int32_t dayOfYear __attribute__((swift_name("dayOfYear")));
@property (readonly) int32_t hours __attribute__((swift_name("hours")));
@property (readonly) int32_t minutes __attribute__((swift_name("minutes")));
@property (readonly) DrapiKtor_utilsMonth *month __attribute__((swift_name("month")));
@property (readonly) int32_t seconds __attribute__((swift_name("seconds")));
@property (readonly) int64_t timestamp __attribute__((swift_name("timestamp")));
@property (readonly) int32_t year __attribute__((swift_name("year")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpStatusCode")))
@interface DrapiKtor_httpHttpStatusCode : KotlinBase
- (instancetype)initWithValue:(int32_t)value description:(NSString *)description __attribute__((swift_name("init(value:description:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (DrapiKtor_httpHttpStatusCode *)doCopyValue:(int32_t)value description:(NSString *)description __attribute__((swift_name("doCopy(value:description:)")));
- (DrapiKtor_httpHttpStatusCode *)descriptionValue:(NSString *)value __attribute__((swift_name("description(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly, getter=description_) NSString *description __attribute__((swift_name("description")));
@property (readonly) int32_t value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpProtocolVersion")))
@interface DrapiKtor_httpHttpProtocolVersion : KotlinBase
- (instancetype)initWithName:(NSString *)name major:(int32_t)major minor:(int32_t)minor __attribute__((swift_name("init(name:major:minor:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (int32_t)component3 __attribute__((swift_name("component3()")));
- (DrapiKtor_httpHttpProtocolVersion *)doCopyName:(NSString *)name major:(int32_t)major minor:(int32_t)minor __attribute__((swift_name("doCopy(name:major:minor:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t major __attribute__((swift_name("major")));
@property (readonly) int32_t minor __attribute__((swift_name("minor")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpRequest")))
@protocol DrapiKtor_client_coreHttpRequest <DrapiKtor_httpHttpMessage, DrapiKotlinx_coroutines_coreCoroutineScope>
@required
@property (readonly) id<DrapiKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) DrapiKtor_client_coreHttpClientCall *call __attribute__((swift_name("call")));
@property (readonly) DrapiKtor_httpOutgoingContent *content __attribute__((swift_name("content")));
@property (readonly) id<DrapiKotlinx_coroutines_coreJob> executionContext __attribute__((swift_name("executionContext")));
@property (readonly) DrapiKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) DrapiKtor_httpUrl *url __attribute__((swift_name("url")));
@end;

__attribute__((swift_name("Ktor_utilsStringValuesBuilder")))
@interface DrapiKtor_utilsStringValuesBuilder : KotlinBase
- (instancetype)initWithCaseInsensitiveName:(BOOL)caseInsensitiveName size:(int32_t)size __attribute__((swift_name("init(caseInsensitiveName:size:)"))) __attribute__((objc_designated_initializer));
- (void)appendName:(NSString *)name value:(NSString *)value __attribute__((swift_name("append(name:value:)")));
- (void)appendAllStringValues:(id<DrapiKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendAll(stringValues:)")));
- (void)appendAllName:(NSString *)name values:(id)values __attribute__((swift_name("appendAll(name:values:)")));
- (void)appendMissingStringValues:(id<DrapiKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendMissing(stringValues:)")));
- (void)appendMissingName:(NSString *)name values:(id)values __attribute__((swift_name("appendMissing(name:values:)")));
- (id<DrapiKtor_utilsStringValues>)build __attribute__((swift_name("build()")));
- (void)clear __attribute__((swift_name("clear()")));
- (BOOL)containsName:(NSString *)name __attribute__((swift_name("contains(name:)")));
- (BOOL)containsName:(NSString *)name value:(NSString *)value __attribute__((swift_name("contains(name:value:)")));
- (NSSet<id<DrapiKotlinMapEntry>> *)entries __attribute__((swift_name("entries()")));
- (NSString * _Nullable)getName:(NSString *)name __attribute__((swift_name("get(name:)")));
- (NSArray<NSString *> * _Nullable)getAllName:(NSString *)name __attribute__((swift_name("getAll(name:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (DrapiMutableSet<NSString *> *)names __attribute__((swift_name("names()")));
- (void)removeName:(NSString *)name __attribute__((swift_name("remove(name:)")));
- (BOOL)removeName:(NSString *)name value:(NSString *)value __attribute__((swift_name("remove(name:value:)")));
- (void)removeKeysWithNoEntries __attribute__((swift_name("removeKeysWithNoEntries()")));
- (void)setName:(NSString *)name value:(NSString *)value __attribute__((swift_name("set(name:value:)")));
@property BOOL built __attribute__((swift_name("built")));
@property (readonly) BOOL caseInsensitiveName __attribute__((swift_name("caseInsensitiveName")));
@property (readonly) DrapiMutableDictionary<NSString *, NSMutableArray<NSString *> *> *values __attribute__((swift_name("values")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHeadersBuilder")))
@interface DrapiKtor_httpHeadersBuilder : DrapiKtor_utilsStringValuesBuilder
- (instancetype)initWithSize:(int32_t)size __attribute__((swift_name("init(size:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCaseInsensitiveName:(BOOL)caseInsensitiveName size:(int32_t)size __attribute__((swift_name("init(caseInsensitiveName:size:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (id<DrapiKtor_httpHeaders>)build __attribute__((swift_name("build()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestData")))
@interface DrapiKtor_client_coreHttpRequestData : KotlinBase
@property (readonly) id<DrapiKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) DrapiKtor_httpOutgoingContent *body __attribute__((swift_name("body")));
@property (readonly) id<DrapiKotlinx_coroutines_coreJob> executionContext __attribute__((swift_name("executionContext")));
@property (readonly) id<DrapiKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@property (readonly) DrapiKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) DrapiKtor_httpUrl *url __attribute__((swift_name("url")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLBuilder")))
@interface DrapiKtor_httpURLBuilder : KotlinBase
- (instancetype)initWithProtocol:(DrapiKtor_httpURLProtocol *)protocol host:(NSString *)host port:(int32_t)port user:(NSString * _Nullable)user password:(NSString * _Nullable)password encodedPath:(NSString *)encodedPath parameters:(DrapiKtor_httpParametersBuilder *)parameters fragment:(NSString *)fragment trailingQuery:(BOOL)trailingQuery __attribute__((swift_name("init(protocol:host:port:user:password:encodedPath:parameters:fragment:trailingQuery:)"))) __attribute__((objc_designated_initializer));
- (DrapiKtor_httpUrl *)build __attribute__((swift_name("build()")));
- (NSString *)buildString __attribute__((swift_name("buildString()")));
- (DrapiKtor_httpURLBuilder *)pathComponents:(DrapiKotlinArray<NSString *> *)components __attribute__((swift_name("path(components:)")));
- (DrapiKtor_httpURLBuilder *)pathComponents_:(NSArray<NSString *> *)components __attribute__((swift_name("path(components_:)")));
@property NSString *encodedPath __attribute__((swift_name("encodedPath")));
@property NSString *fragment __attribute__((swift_name("fragment")));
@property NSString *host __attribute__((swift_name("host")));
@property (readonly) DrapiKtor_httpParametersBuilder *parameters __attribute__((swift_name("parameters")));
@property NSString * _Nullable password __attribute__((swift_name("password")));
@property int32_t port __attribute__((swift_name("port")));
@property DrapiKtor_httpURLProtocol *protocol __attribute__((swift_name("protocol")));
@property BOOL trailingQuery __attribute__((swift_name("trailingQuery")));
@property NSString * _Nullable user __attribute__((swift_name("user")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpMethod")))
@interface DrapiKtor_httpHttpMethod : KotlinBase
- (instancetype)initWithValue:(NSString *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (DrapiKtor_httpHttpMethod *)doCopyValue:(NSString *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreTypeInfo")))
@interface DrapiKtor_client_coreTypeInfo : KotlinBase
- (instancetype)initWithType:(id<DrapiKotlinKClass>)type reifiedType:(id<DrapiKtor_client_coreType>)reifiedType __attribute__((swift_name("init(type:reifiedType:)"))) __attribute__((objc_designated_initializer));
- (id<DrapiKotlinKClass>)component1 __attribute__((swift_name("component1()")));
- (id<DrapiKtor_client_coreType>)component2 __attribute__((swift_name("component2()")));
- (DrapiKtor_client_coreTypeInfo *)doCopyType:(id<DrapiKotlinKClass>)type reifiedType:(id<DrapiKtor_client_coreType>)reifiedType __attribute__((swift_name("doCopy(type:reifiedType:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<DrapiKtor_client_coreType> reifiedType __attribute__((swift_name("reifiedType")));
@property (readonly) id<DrapiKotlinKClass> type __attribute__((swift_name("type")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreAtomicDesc")))
@interface DrapiKotlinx_coroutines_coreAtomicDesc : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeOp:(DrapiKotlinx_coroutines_coreAtomicOp<id> *)op failure:(id _Nullable)failure __attribute__((swift_name("complete(op:failure:)")));
- (id _Nullable)prepareOp:(DrapiKotlinx_coroutines_coreAtomicOp<id> *)op __attribute__((swift_name("prepare(op:)")));
@end;

__attribute__((swift_name("Kotlinx_ioCharsetDecoder")))
@interface DrapiKotlinx_ioCharsetDecoder : KotlinBase
- (instancetype)initWith_charset:(DrapiKotlinx_ioCharset *)_charset __attribute__((swift_name("init(_charset:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_ioCharsetEncoder")))
@interface DrapiKotlinx_ioCharsetEncoder : KotlinBase
- (instancetype)initWith_charset:(DrapiKotlinx_ioCharset *)_charset __attribute__((swift_name("init(_charset:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinMapEntry")))
@protocol DrapiKotlinMapEntry
@required
@property (readonly) id _Nullable key __attribute__((swift_name("key")));
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_ioReadSession")))
@protocol DrapiKotlinx_coroutines_ioReadSession
@required
- (int32_t)discardN:(int32_t)n __attribute__((swift_name("discard(n:)")));
- (DrapiKotlinx_ioIoBuffer * _Nullable)requestAtLeast:(int32_t)atLeast __attribute__((swift_name("request(atLeast:)")));
@property (readonly) int32_t availableForRead __attribute__((swift_name("availableForRead")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_ioByteOrder")))
@interface DrapiKotlinx_ioByteOrder : DrapiKotlinEnum<DrapiKotlinx_ioByteOrder *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
@property (class, readonly) DrapiKotlinx_ioByteOrder *bigEndian __attribute__((swift_name("bigEndian")));
@property (class, readonly) DrapiKotlinx_ioByteOrder *littleEndian __attribute__((swift_name("littleEndian")));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (int32_t)compareToOther:(DrapiKotlinx_ioByteOrder *)other __attribute__((swift_name("compareTo(other:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsWeekDay")))
@interface DrapiKtor_utilsWeekDay : DrapiKotlinEnum<DrapiKtor_utilsWeekDay *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
@property (class, readonly) DrapiKtor_utilsWeekDay *monday __attribute__((swift_name("monday")));
@property (class, readonly) DrapiKtor_utilsWeekDay *tuesday __attribute__((swift_name("tuesday")));
@property (class, readonly) DrapiKtor_utilsWeekDay *wednesday __attribute__((swift_name("wednesday")));
@property (class, readonly) DrapiKtor_utilsWeekDay *thursday __attribute__((swift_name("thursday")));
@property (class, readonly) DrapiKtor_utilsWeekDay *friday __attribute__((swift_name("friday")));
@property (class, readonly) DrapiKtor_utilsWeekDay *saturday __attribute__((swift_name("saturday")));
@property (class, readonly) DrapiKtor_utilsWeekDay *sunday __attribute__((swift_name("sunday")));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (int32_t)compareToOther:(DrapiKtor_utilsWeekDay *)other __attribute__((swift_name("compareTo(other:)")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsMonth")))
@interface DrapiKtor_utilsMonth : DrapiKotlinEnum<DrapiKtor_utilsMonth *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
@property (class, readonly) DrapiKtor_utilsMonth *january __attribute__((swift_name("january")));
@property (class, readonly) DrapiKtor_utilsMonth *february __attribute__((swift_name("february")));
@property (class, readonly) DrapiKtor_utilsMonth *march __attribute__((swift_name("march")));
@property (class, readonly) DrapiKtor_utilsMonth *april __attribute__((swift_name("april")));
@property (class, readonly) DrapiKtor_utilsMonth *may __attribute__((swift_name("may")));
@property (class, readonly) DrapiKtor_utilsMonth *june __attribute__((swift_name("june")));
@property (class, readonly) DrapiKtor_utilsMonth *july __attribute__((swift_name("july")));
@property (class, readonly) DrapiKtor_utilsMonth *august __attribute__((swift_name("august")));
@property (class, readonly) DrapiKtor_utilsMonth *september __attribute__((swift_name("september")));
@property (class, readonly) DrapiKtor_utilsMonth *october __attribute__((swift_name("october")));
@property (class, readonly) DrapiKtor_utilsMonth *november __attribute__((swift_name("november")));
@property (class, readonly) DrapiKtor_utilsMonth *december __attribute__((swift_name("december")));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (int32_t)compareToOther:(DrapiKtor_utilsMonth *)other __attribute__((swift_name("compareTo(other:)")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("Ktor_httpOutgoingContent")))
@interface DrapiKtor_httpOutgoingContent : KotlinBase
- (id _Nullable)getPropertyKey:(DrapiKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("getProperty(key:)")));
- (void)setPropertyKey:(DrapiKtor_utilsAttributeKey<id> *)key value:(id _Nullable)value __attribute__((swift_name("setProperty(key:value:)")));
@property (readonly) DrapiLong * _Nullable contentLength __attribute__((swift_name("contentLength")));
@property (readonly) DrapiKtor_httpContentType * _Nullable contentType __attribute__((swift_name("contentType")));
@property (readonly) id<DrapiKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@property (readonly) DrapiKtor_httpHttpStatusCode * _Nullable status __attribute__((swift_name("status")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpUrl")))
@interface DrapiKtor_httpUrl : KotlinBase
- (instancetype)initWithProtocol:(DrapiKtor_httpURLProtocol *)protocol host:(NSString *)host specifiedPort:(int32_t)specifiedPort encodedPath:(NSString *)encodedPath parameters:(id<DrapiKtor_httpParameters>)parameters fragment:(NSString *)fragment user:(NSString * _Nullable)user password:(NSString * _Nullable)password trailingQuery:(BOOL)trailingQuery __attribute__((swift_name("init(protocol:host:specifiedPort:encodedPath:parameters:fragment:user:password:trailingQuery:)"))) __attribute__((objc_designated_initializer));
- (DrapiKtor_httpURLProtocol *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (int32_t)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (id<DrapiKtor_httpParameters>)component5 __attribute__((swift_name("component5()")));
- (NSString *)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (NSString * _Nullable)component8 __attribute__((swift_name("component8()")));
- (BOOL)component9 __attribute__((swift_name("component9()")));
- (DrapiKtor_httpUrl *)doCopyProtocol:(DrapiKtor_httpURLProtocol *)protocol host:(NSString *)host specifiedPort:(int32_t)specifiedPort encodedPath:(NSString *)encodedPath parameters:(id<DrapiKtor_httpParameters>)parameters fragment:(NSString *)fragment user:(NSString * _Nullable)user password:(NSString * _Nullable)password trailingQuery:(BOOL)trailingQuery __attribute__((swift_name("doCopy(protocol:host:specifiedPort:encodedPath:parameters:fragment:user:password:trailingQuery:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *encodedPath __attribute__((swift_name("encodedPath")));
@property (readonly) NSString *fragment __attribute__((swift_name("fragment")));
@property (readonly) NSString *host __attribute__((swift_name("host")));
@property (readonly) id<DrapiKtor_httpParameters> parameters __attribute__((swift_name("parameters")));
@property (readonly) NSString * _Nullable password __attribute__((swift_name("password")));
@property (readonly) int32_t port __attribute__((swift_name("port")));
@property (readonly) DrapiKtor_httpURLProtocol *protocol __attribute__((swift_name("protocol")));
@property (readonly) int32_t specifiedPort __attribute__((swift_name("specifiedPort")));
@property (readonly) BOOL trailingQuery __attribute__((swift_name("trailingQuery")));
@property (readonly) NSString * _Nullable user __attribute__((swift_name("user")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLProtocol")))
@interface DrapiKtor_httpURLProtocol : KotlinBase
- (instancetype)initWithName:(NSString *)name defaultPort:(int32_t)defaultPort __attribute__((swift_name("init(name:defaultPort:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (DrapiKtor_httpURLProtocol *)doCopyName:(NSString *)name defaultPort:(int32_t)defaultPort __attribute__((swift_name("doCopy(name:defaultPort:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t defaultPort __attribute__((swift_name("defaultPort")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpParametersBuilder")))
@interface DrapiKtor_httpParametersBuilder : DrapiKtor_utilsStringValuesBuilder
- (instancetype)initWithSize:(int32_t)size __attribute__((swift_name("init(size:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCaseInsensitiveName:(BOOL)caseInsensitiveName size:(int32_t)size __attribute__((swift_name("init(caseInsensitiveName:size:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (id<DrapiKtor_httpParameters>)build __attribute__((swift_name("build()")));
@end;

__attribute__((swift_name("Ktor_client_coreType")))
@protocol DrapiKtor_client_coreType
@required
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreOpDescriptor")))
@interface DrapiKotlinx_coroutines_coreOpDescriptor : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreAtomicOp")))
@interface DrapiKotlinx_coroutines_coreAtomicOp<__contravariant T> : DrapiKotlinx_coroutines_coreOpDescriptor
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeAffected:(T _Nullable)affected failure:(id _Nullable)failure __attribute__((swift_name("complete(affected:failure:)")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
- (id _Nullable)prepareAffected:(T _Nullable)affected __attribute__((swift_name("prepare(affected:)")));
- (BOOL)tryDecideDecision:(id _Nullable)decision __attribute__((swift_name("tryDecide(decision:)")));
@property (readonly) BOOL isDecided __attribute__((swift_name("isDecided")));
@end;

__attribute__((swift_name("Kotlinx_ioInput")))
@protocol DrapiKotlinx_ioInput <DrapiKotlinx_ioCloseable>
@required
- (int64_t)discardN_:(int64_t)n __attribute__((swift_name("discard(n_:)")));
- (int32_t)peekToBuffer:(DrapiKotlinx_ioIoBuffer *)buffer __attribute__((swift_name("peekTo(buffer:)")));
- (int32_t)readAvailableDst:(DrapiKotlinByteArray *)dst offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length:)")));
- (int32_t)readAvailableDst:(DrapiKotlinDoubleArray *)dst offset:(int32_t)offset length_:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length_:)")));
- (int32_t)readAvailableDst:(DrapiKotlinFloatArray *)dst offset:(int32_t)offset length__:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length__:)")));
- (int32_t)readAvailableDst:(DrapiKotlinIntArray *)dst offset:(int32_t)offset length___:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length___:)")));
- (int32_t)readAvailableDst:(DrapiKotlinLongArray *)dst offset:(int32_t)offset length____:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length____:)")));
- (int32_t)readAvailableDst:(DrapiKotlinShortArray *)dst offset:(int32_t)offset length_____:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length_____:)")));
- (int32_t)readAvailableDst:(void *)dst offset:(int32_t)offset length______:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length______:)")));
- (int64_t)readAvailableDst:(void *)dst offset:(int64_t)offset length_______:(int64_t)length __attribute__((swift_name("readAvailable(dst:offset:length_______:)")));
- (int32_t)readAvailableDst:(DrapiKotlinx_ioIoBuffer *)dst length:(int32_t)length __attribute__((swift_name("readAvailable(dst:length:)")));
- (int8_t)readByte __attribute__((swift_name("readByte()")));
- (double)readDouble __attribute__((swift_name("readDouble()")));
- (float)readFloat __attribute__((swift_name("readFloat()")));
- (void)readFullyDst:(DrapiKotlinByteArray *)dst offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length:)")));
- (void)readFullyDst:(DrapiKotlinDoubleArray *)dst offset:(int32_t)offset length_:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length_:)")));
- (void)readFullyDst:(DrapiKotlinFloatArray *)dst offset:(int32_t)offset length__:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length__:)")));
- (void)readFullyDst:(DrapiKotlinIntArray *)dst offset:(int32_t)offset length___:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length___:)")));
- (void)readFullyDst:(DrapiKotlinLongArray *)dst offset:(int32_t)offset length____:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length____:)")));
- (void)readFullyDst:(DrapiKotlinShortArray *)dst offset:(int32_t)offset length_____:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length_____:)")));
- (void)readFullyDst:(void *)dst offset:(int32_t)offset length______:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length______:)")));
- (void)readFullyDst:(void *)dst offset:(int64_t)offset length_______:(int64_t)length __attribute__((swift_name("readFully(dst:offset:length_______:)")));
- (void)readFullyDst:(DrapiKotlinx_ioIoBuffer *)dst length:(int32_t)length __attribute__((swift_name("readFully(dst:length:)")));
- (int32_t)readInt __attribute__((swift_name("readInt()")));
- (int64_t)readLong __attribute__((swift_name("readLong()")));
- (int16_t)readShort __attribute__((swift_name("readShort()")));
- (int32_t)tryPeek __attribute__((swift_name("tryPeek()")));
@property DrapiKotlinx_ioByteOrder *byteOrder __attribute__((swift_name("byteOrder")));
@property (readonly) DrapiKotlinNothing *doNotImplementInputButExtendAbstractInputInstead __attribute__((swift_name("doNotImplementInputButExtendAbstractInputInstead")));
@property (readonly) BOOL endOfInput __attribute__((swift_name("endOfInput")));
@end;

__attribute__((swift_name("KotlinAppendable")))
@protocol DrapiKotlinAppendable
@required
- (id<DrapiKotlinAppendable>)appendC:(unichar)c __attribute__((swift_name("append(c:)")));
- (id<DrapiKotlinAppendable>)appendCsq:(id _Nullable)csq __attribute__((swift_name("append(csq:)")));
- (id<DrapiKotlinAppendable>)appendCsq:(id _Nullable)csq start:(int32_t)start end_:(int32_t)end __attribute__((swift_name("append(csq:start:end_:)")));
@end;

__attribute__((swift_name("Kotlinx_ioOutput")))
@protocol DrapiKotlinx_ioOutput <DrapiKotlinAppendable, DrapiKotlinx_ioCloseable>
@required
- (id<DrapiKotlinAppendable>)appendCsq:(DrapiKotlinCharArray *)csq start:(int32_t)start end:(int32_t)end __attribute__((swift_name("append(csq:start:end:)")));
- (void)fillN:(int64_t)n v:(int8_t)v __attribute__((swift_name("fill(n:v:)")));
- (void)flush __attribute__((swift_name("flush()")));
- (void)writeByteV:(int8_t)v __attribute__((swift_name("writeByte(v:)")));
- (void)writeDoubleV:(double)v __attribute__((swift_name("writeDouble(v:)")));
- (void)writeFloatV:(float)v __attribute__((swift_name("writeFloat(v:)")));
- (void)writeFullySrc:(DrapiKotlinByteArray *)src offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length:)")));
- (void)writeFullySrc:(DrapiKotlinDoubleArray *)src offset:(int32_t)offset length_:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length_:)")));
- (void)writeFullySrc:(DrapiKotlinFloatArray *)src offset:(int32_t)offset length__:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length__:)")));
- (void)writeFullySrc:(DrapiKotlinIntArray *)src offset:(int32_t)offset length___:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length___:)")));
- (void)writeFullySrc:(DrapiKotlinLongArray *)src offset:(int32_t)offset length____:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length____:)")));
- (void)writeFullySrc:(DrapiKotlinShortArray *)src offset:(int32_t)offset length_____:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length_____:)")));
- (void)writeFullySrc:(void *)src offset:(int32_t)offset length______:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length______:)")));
- (void)writeFullySrc:(void *)src offset:(int64_t)offset length_______:(int64_t)length __attribute__((swift_name("writeFully(src:offset:length_______:)")));
- (void)writeFullySrc:(DrapiKotlinx_ioIoBuffer *)src length:(int32_t)length __attribute__((swift_name("writeFully(src:length:)")));
- (void)writeIntV:(int32_t)v __attribute__((swift_name("writeInt(v:)")));
- (void)writeLongV:(int64_t)v __attribute__((swift_name("writeLong(v:)")));
- (void)writeShortV:(int16_t)v __attribute__((swift_name("writeShort(v:)")));
@property DrapiKotlinx_ioByteOrder *byteOrder __attribute__((swift_name("byteOrder")));
@property (readonly) DrapiKotlinNothing *doNotImplementOutputButExtendAbstractOutputInstead __attribute__((swift_name("doNotImplementOutputButExtendAbstractOutputInstead")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_ioIoBuffer")))
@interface DrapiKotlinx_ioIoBuffer : KotlinBase <DrapiKotlinx_ioInput, DrapiKotlinx_ioOutput>
- (instancetype)initWithContent:(void *)content contentCapacity:(int32_t)contentCapacity __attribute__((swift_name("init(content:contentCapacity:)"))) __attribute__((objc_designated_initializer));
- (id<DrapiKotlinAppendable>)appendC:(unichar)c __attribute__((swift_name("append(c:)")));
- (id<DrapiKotlinAppendable>)appendCsq:(DrapiKotlinCharArray *)csq start:(int32_t)start end:(int32_t)end __attribute__((swift_name("append(csq:start:end:)")));
- (id<DrapiKotlinAppendable>)appendCsq:(id _Nullable)csq __attribute__((swift_name("append(csq:)")));
- (id<DrapiKotlinAppendable>)appendCsq:(id _Nullable)csq start:(int32_t)start end_:(int32_t)end __attribute__((swift_name("append(csq:start:end_:)")));
- (int32_t)appendCharsCsq:(DrapiKotlinCharArray *)csq start:(int32_t)start end:(int32_t)end __attribute__((swift_name("appendChars(csq:start:end:)")));
- (int32_t)appendCharsCsq:(id)csq start:(int32_t)start end_:(int32_t)end __attribute__((swift_name("appendChars(csq:start:end_:)")));
- (BOOL)canRead __attribute__((swift_name("canRead()")));
- (BOOL)canWrite __attribute__((swift_name("canWrite()")));
- (void)close __attribute__((swift_name("close()")));
- (int64_t)discardN_:(int64_t)n __attribute__((swift_name("discard(n_:)")));
- (void)discardExactN:(int32_t)n __attribute__((swift_name("discardExact(n:)")));
- (void)fillN:(int64_t)n v:(int8_t)v __attribute__((swift_name("fill(n:v:)")));
- (void)flush __attribute__((swift_name("flush()")));
- (BOOL)isExclusivelyOwned __attribute__((swift_name("isExclusivelyOwned()")));
- (DrapiKotlinx_ioIoBuffer *)makeView __attribute__((swift_name("makeView()")));
- (int32_t)peekToBuffer:(DrapiKotlinx_ioIoBuffer *)buffer __attribute__((swift_name("peekTo(buffer:)")));
- (void)pushBackN:(int32_t)n __attribute__((swift_name("pushBack(n:)")));
- (void)readDst:(DrapiKotlinByteArray *)dst offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("read(dst:offset:length:)")));
- (int32_t)readAvailableDst:(DrapiKotlinByteArray *)dst offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length:)")));
- (int32_t)readAvailableDst:(DrapiKotlinDoubleArray *)dst offset:(int32_t)offset length_:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length_:)")));
- (int32_t)readAvailableDst:(DrapiKotlinFloatArray *)dst offset:(int32_t)offset length__:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length__:)")));
- (int32_t)readAvailableDst:(DrapiKotlinIntArray *)dst offset:(int32_t)offset length___:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length___:)")));
- (int32_t)readAvailableDst:(DrapiKotlinLongArray *)dst offset:(int32_t)offset length____:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length____:)")));
- (int32_t)readAvailableDst:(DrapiKotlinShortArray *)dst offset:(int32_t)offset length_____:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length_____:)")));
- (int32_t)readAvailableDst:(void *)dst offset:(int32_t)offset length______:(int32_t)length __attribute__((swift_name("readAvailable(dst:offset:length______:)")));
- (int64_t)readAvailableDst:(void *)dst offset:(int64_t)offset length_______:(int64_t)length __attribute__((swift_name("readAvailable(dst:offset:length_______:)")));
- (int32_t)readAvailableDst:(DrapiKotlinx_ioIoBuffer *)dst length:(int32_t)length __attribute__((swift_name("readAvailable(dst:length:)")));
- (int8_t)readByte __attribute__((swift_name("readByte()")));
- (int32_t)readDirectBlock:(DrapiInt *(^)(id))block __attribute__((swift_name("readDirect(block:)")));
- (double)readDouble __attribute__((swift_name("readDouble()")));
- (float)readFloat __attribute__((swift_name("readFloat()")));
- (void)readFullyDst:(DrapiKotlinByteArray *)dst offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length:)")));
- (void)readFullyDst:(DrapiKotlinDoubleArray *)dst offset:(int32_t)offset length_:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length_:)")));
- (void)readFullyDst:(DrapiKotlinFloatArray *)dst offset:(int32_t)offset length__:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length__:)")));
- (void)readFullyDst:(DrapiKotlinIntArray *)dst offset:(int32_t)offset length___:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length___:)")));
- (void)readFullyDst:(DrapiKotlinLongArray *)dst offset:(int32_t)offset length____:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length____:)")));
- (void)readFullyDst:(DrapiKotlinShortArray *)dst offset:(int32_t)offset length_____:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length_____:)")));
- (void)readFullyDst:(void *)dst offset:(int32_t)offset length______:(int32_t)length __attribute__((swift_name("readFully(dst:offset:length______:)")));
- (void)readFullyDst:(void *)dst offset:(int64_t)offset length_______:(int64_t)length __attribute__((swift_name("readFully(dst:offset:length_______:)")));
- (void)readFullyDst:(DrapiKotlinx_ioIoBuffer *)dst length:(int32_t)length __attribute__((swift_name("readFully(dst:length:)")));
- (int32_t)readInt __attribute__((swift_name("readInt()")));
- (int64_t)readLong __attribute__((swift_name("readLong()")));
- (int16_t)readShort __attribute__((swift_name("readShort()")));
- (void)releasePool:(id<DrapiKotlinx_ioObjectPool>)pool __attribute__((swift_name("release(pool:)")));
- (void)reserveEndGapN:(int32_t)n __attribute__((swift_name("reserveEndGap(n:)")));
- (void)reserveStartGapN:(int32_t)n __attribute__((swift_name("reserveStartGap(n:)")));
- (void)resetForRead __attribute__((swift_name("resetForRead()")));
- (void)resetForWrite __attribute__((swift_name("resetForWrite()")));
- (void)resetForWriteLimit:(int32_t)limit __attribute__((swift_name("resetForWrite(limit:)")));
- (NSString *)description __attribute__((swift_name("description()")));
- (int32_t)tryPeek __attribute__((swift_name("tryPeek()")));
- (void)writeArray:(DrapiKotlinByteArray *)array offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("write(array:offset:length:)")));
- (int32_t)writeBufferSrc:(DrapiKotlinx_ioIoBuffer *)src length:(int32_t)length __attribute__((swift_name("writeBuffer(src:length:)")));
- (void)writeByteV:(int8_t)v __attribute__((swift_name("writeByte(v:)")));
- (int32_t)writeDirectBlock:(DrapiInt *(^)(id))block __attribute__((swift_name("writeDirect(block:)")));
- (void)writeDoubleV:(double)v __attribute__((swift_name("writeDouble(v:)")));
- (void)writeFloatV:(float)v __attribute__((swift_name("writeFloat(v:)")));
- (void)writeFullySrc:(DrapiKotlinByteArray *)src offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length:)")));
- (void)writeFullySrc:(DrapiKotlinDoubleArray *)src offset:(int32_t)offset length_:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length_:)")));
- (void)writeFullySrc:(DrapiKotlinFloatArray *)src offset:(int32_t)offset length__:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length__:)")));
- (void)writeFullySrc:(DrapiKotlinIntArray *)src offset:(int32_t)offset length___:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length___:)")));
- (void)writeFullySrc:(DrapiKotlinLongArray *)src offset:(int32_t)offset length____:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length____:)")));
- (void)writeFullySrc:(DrapiKotlinShortArray *)src offset:(int32_t)offset length_____:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length_____:)")));
- (void)writeFullySrc:(void *)src offset:(int32_t)offset length______:(int32_t)length __attribute__((swift_name("writeFully(src:offset:length______:)")));
- (void)writeFullySrc:(void *)src offset:(int64_t)offset length_______:(int64_t)length __attribute__((swift_name("writeFully(src:offset:length_______:)")));
- (void)writeFullySrc:(DrapiKotlinx_ioIoBuffer *)src length:(int32_t)length __attribute__((swift_name("writeFully(src:length:)")));
- (void)writeIntV:(int32_t)v __attribute__((swift_name("writeInt(v:)")));
- (void)writeLongV:(int64_t)v __attribute__((swift_name("writeLong(v:)")));
- (void)writeShortV:(int16_t)v __attribute__((swift_name("writeShort(v:)")));
@property id _Nullable attachment __attribute__((swift_name("attachment")));
@property DrapiKotlinx_ioByteOrder *byteOrder __attribute__((swift_name("byteOrder")));
@property (readonly) int32_t capacity __attribute__((swift_name("capacity")));
@property (readonly) DrapiKotlinNothing *doNotImplementInputButExtendAbstractInputInstead __attribute__((swift_name("doNotImplementInputButExtendAbstractInputInstead")));
@property (readonly) DrapiKotlinNothing *doNotImplementOutputButExtendAbstractOutputInstead __attribute__((swift_name("doNotImplementOutputButExtendAbstractOutputInstead")));
@property (readonly) int32_t endGap __attribute__((swift_name("endGap")));
@property (readonly) BOOL endOfInput __attribute__((swift_name("endOfInput")));
@property DrapiKotlinx_ioIoBuffer * _Nullable next __attribute__((swift_name("next")));
@property (readonly) int32_t readRemaining __attribute__((swift_name("readRemaining")));
@property (readonly) int32_t startGap __attribute__((swift_name("startGap")));
@property (readonly) int32_t writeRemaining __attribute__((swift_name("writeRemaining")));
@end;

__attribute__((swift_name("Ktor_httpHeaderValueWithParameters")))
@interface DrapiKtor_httpHeaderValueWithParameters : KotlinBase
- (instancetype)initWithContent:(NSString *)content parameters:(NSArray<DrapiKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(content:parameters:)"))) __attribute__((objc_designated_initializer));
- (NSString * _Nullable)parameterName:(NSString *)name __attribute__((swift_name("parameter(name:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *content __attribute__((swift_name("content")));
@property (readonly) NSArray<DrapiKtor_httpHeaderValueParam *> *parameters __attribute__((swift_name("parameters")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpContentType")))
@interface DrapiKtor_httpContentType : DrapiKtor_httpHeaderValueWithParameters
- (instancetype)initWithContentType:(NSString *)contentType contentSubtype:(NSString *)contentSubtype parameters:(NSArray<DrapiKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(contentType:contentSubtype:parameters:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithContent:(NSString *)content parameters:(NSArray<DrapiKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(content:parameters:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)matchPattern:(DrapiKtor_httpContentType *)pattern __attribute__((swift_name("match(pattern:)")));
- (BOOL)matchPattern_:(NSString *)pattern __attribute__((swift_name("match(pattern_:)")));
- (DrapiKtor_httpContentType *)withParameterName:(NSString *)name value:(NSString *)value __attribute__((swift_name("withParameter(name:value:)")));
- (DrapiKtor_httpContentType *)withoutParameters __attribute__((swift_name("withoutParameters()")));
@property (readonly) NSString *contentSubtype __attribute__((swift_name("contentSubtype")));
@property (readonly) NSString *contentType __attribute__((swift_name("contentType")));
@end;

__attribute__((swift_name("Ktor_httpParameters")))
@protocol DrapiKtor_httpParameters <DrapiKtor_utilsStringValues>
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinByteArray")))
@interface DrapiKotlinByteArray : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(DrapiByte *(^)(DrapiInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int8_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (DrapiKotlinByteIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinDoubleArray")))
@interface DrapiKotlinDoubleArray : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(DrapiDouble *(^)(DrapiInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (double)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (DrapiKotlinDoubleIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(double)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinFloatArray")))
@interface DrapiKotlinFloatArray : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(DrapiFloat *(^)(DrapiInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (float)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (DrapiKotlinFloatIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(float)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinIntArray")))
@interface DrapiKotlinIntArray : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(DrapiInt *(^)(DrapiInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int32_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (DrapiKotlinIntIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int32_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinLongArray")))
@interface DrapiKotlinLongArray : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(DrapiLong *(^)(DrapiInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int64_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (DrapiKotlinLongIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int64_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinShortArray")))
@interface DrapiKotlinShortArray : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(DrapiShort *(^)(DrapiInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int16_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (DrapiKotlinShortIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int16_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinCharArray")))
@interface DrapiKotlinCharArray : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(id (^)(DrapiInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (unichar)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (DrapiKotlinCharIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(unichar)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("Kotlinx_ioObjectPool")))
@protocol DrapiKotlinx_ioObjectPool <DrapiKotlinx_ioCloseable>
@required
- (id)borrow __attribute__((swift_name("borrow()")));
- (void)dispose __attribute__((swift_name("dispose()")));
- (void)recycleInstance:(id)instance __attribute__((swift_name("recycle(instance:)")));
@property (readonly) int32_t capacity __attribute__((swift_name("capacity")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHeaderValueParam")))
@interface DrapiKtor_httpHeaderValueParam : KotlinBase
- (instancetype)initWithName:(NSString *)name value:(NSString *)value __attribute__((swift_name("init(name:value:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (DrapiKtor_httpHeaderValueParam *)doCopyName:(NSString *)name value:(NSString *)value __attribute__((swift_name("doCopy(name:value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("KotlinByteIterator")))
@interface DrapiKotlinByteIterator : KotlinBase <DrapiKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (DrapiByte *)next __attribute__((swift_name("next()")));
- (int8_t)nextByte __attribute__((swift_name("nextByte()")));
@end;

__attribute__((swift_name("KotlinDoubleIterator")))
@interface DrapiKotlinDoubleIterator : KotlinBase <DrapiKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (DrapiDouble *)next __attribute__((swift_name("next()")));
- (double)nextDouble __attribute__((swift_name("nextDouble()")));
@end;

__attribute__((swift_name("KotlinFloatIterator")))
@interface DrapiKotlinFloatIterator : KotlinBase <DrapiKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (DrapiFloat *)next __attribute__((swift_name("next()")));
- (float)nextFloat __attribute__((swift_name("nextFloat()")));
@end;

__attribute__((swift_name("KotlinIntIterator")))
@interface DrapiKotlinIntIterator : KotlinBase <DrapiKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (DrapiInt *)next __attribute__((swift_name("next()")));
- (int32_t)nextInt __attribute__((swift_name("nextInt()")));
@end;

__attribute__((swift_name("KotlinLongIterator")))
@interface DrapiKotlinLongIterator : KotlinBase <DrapiKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (DrapiLong *)next __attribute__((swift_name("next()")));
- (int64_t)nextLong __attribute__((swift_name("nextLong()")));
@end;

__attribute__((swift_name("KotlinShortIterator")))
@interface DrapiKotlinShortIterator : KotlinBase <DrapiKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (DrapiShort *)next __attribute__((swift_name("next()")));
- (int16_t)nextShort __attribute__((swift_name("nextShort()")));
@end;

__attribute__((swift_name("KotlinCharIterator")))
@interface DrapiKotlinCharIterator : KotlinBase <DrapiKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (id)next __attribute__((swift_name("next()")));
- (unichar)nextChar __attribute__((swift_name("nextChar()")));
@end;

NS_ASSUME_NONNULL_END
