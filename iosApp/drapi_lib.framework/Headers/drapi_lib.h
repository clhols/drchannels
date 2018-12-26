#import <Foundation/Foundation.h>

@class Drapi_libDate, Drapi_libDateSerializer, Drapi_libSearchResult, Drapi_libProgramCard, Drapi_libMuPaging, Drapi_libSearchResultCompanion, Drapi_libSearchResult$serializer, Drapi_libMuPagingCompanion, Drapi_libMuPaging$serializer, Drapi_libSchedule, Drapi_libMuScheduleBroadcast, Drapi_libScheduleCompanion, Drapi_libSchedule$serializer, Drapi_libChannel, Drapi_libMuStreamingServer, Drapi_libChannelCompanion, Drapi_libChannel$serializer, Drapi_libMuStreamQuality, Drapi_libMuStreamingServerCompanion, Drapi_libMuStreamingServer$serializer, Drapi_libMuStream, Drapi_libMuStreamQualityCompanion, Drapi_libMuStreamQuality$serializer, Drapi_libMuStreamCompanion, Drapi_libMuStream$serializer, Drapi_libMuNowNext, Drapi_libMuNowNextCompanion, Drapi_libMuNowNext$serializer, Drapi_libMuScheduleBroadcastCompanion, Drapi_libMuScheduleBroadcast$serializer, Drapi_libPrimaryAsset, Drapi_libInfo, Drapi_libProgramCardCompanion, Drapi_libProgramCard$serializer, Drapi_libInfoCompanion, Drapi_libInfo$serializer, Drapi_libPrimaryAssetCompanion, Drapi_libPrimaryAsset$serializer, Drapi_libManifest, Drapi_libLink, Drapi_libSubtitle, Drapi_libManifestCompanion, Drapi_libManifest$serializer, Drapi_libLinkCompanion, Drapi_libLink$serializer, Drapi_libSubtitleCompanion, Drapi_libSubtitle$serializer, Drapi_libMostViewed, Drapi_libMostViewedCompanion, Drapi_libMostViewed$serializer, Drapi_libDrMuException, Drapi_libKotlinException, Drapi_libKotlinThrowable, Drapi_libKotlinArray, Drapi_libDrMuRepository, Drapi_libHttpClientFactory, Drapi_libKtor_client_core_iosHttpClient, Drapi_libDrMuRepositoryCallback, Drapi_libKotlinUnit, Drapi_libKotlinx_serialization_runtime_nativeEnumDescriptor, Drapi_libKotlinx_serialization_runtime_nativeSerialKind, Drapi_libKotlinNothing, Drapi_libKotlinx_serialization_runtime_nativeUpdateMode, Drapi_libKtor_client_core_iosHttpClientConfig, Drapi_libKotlinx_coroutines_core_nativeCoroutineDispatcher, Drapi_libKtor_client_core_iosHttpClientEngineConfig, Drapi_libKtor_client_core_iosHttpReceivePipeline, Drapi_libKtor_client_core_iosHttpRequestPipeline, Drapi_libKtor_client_core_iosHttpResponsePipeline, Drapi_libKtor_client_core_iosHttpSendPipeline, Drapi_libKotlinx_coroutines_core_nativeCancellationException, Drapi_libKotlinx_serialization_runtime_nativeSerialClassDescImpl, Drapi_libKotlinEnum, Drapi_libKtor_utils_iosAttributeKey, Drapi_libKotlinAbstractCoroutineContextElement, Drapi_libKtor_client_core_iosHttpResponseConfig, Drapi_libKtor_utils_iosPipeline, Drapi_libKtor_utils_iosPipelinePhase, Drapi_libKotlinIllegalStateException, Drapi_libKotlinRuntimeException, Drapi_libKotlinx_io_nativeCharset, Drapi_libKotlinx_coroutines_core_nativeAtomicDesc, Drapi_libKotlinx_io_nativeCharsetDecoder, Drapi_libKotlinx_io_nativeCharsetEncoder, Drapi_libKotlinx_coroutines_core_nativeAtomicOp, Drapi_libKotlinx_coroutines_core_nativeOpDescriptor;

@protocol Drapi_libKotlinx_serialization_runtime_nativeKSerializer, Drapi_libKotlinx_serialization_runtime_nativeSerializationStrategy, Drapi_libKotlinx_serialization_runtime_nativeEncoder, Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor, Drapi_libKotlinx_serialization_runtime_nativeDeserializationStrategy, Drapi_libKotlinx_serialization_runtime_nativeDecoder, Drapi_libKotlinx_coroutines_core_nativeCoroutineScope, Drapi_libKotlinCoroutineContext, Drapi_libKotlinx_coroutines_core_nativeJob, Drapi_libKotlinx_serialization_runtime_nativeCompositeEncoder, Drapi_libKotlinx_serialization_runtime_nativeSerialContext, Drapi_libKotlinAnnotation, Drapi_libKotlinx_serialization_runtime_nativeCompositeDecoder, Drapi_libKotlinIterator, Drapi_libKotlinx_io_nativeCloseable, Drapi_libKtor_client_core_iosHttpClientEngine, Drapi_libKtor_utils_iosAttributes, Drapi_libKotlinCoroutineContextElement, Drapi_libKotlinCoroutineContextKey, Drapi_libKotlinx_coroutines_core_nativeChildHandle, Drapi_libKotlinx_coroutines_core_nativeChildJob, Drapi_libKotlinx_coroutines_core_nativeDisposableHandle, Drapi_libKotlinSequence, Drapi_libKotlinx_coroutines_core_nativeSelectClause0, Drapi_libKotlinx_serialization_runtime_nativeGeneratedSerializer, Drapi_libKotlinKClass, Drapi_libKotlinComparable, Drapi_libKtor_client_core_iosHttpClientFeature, Drapi_libKotlinContinuationInterceptor, Drapi_libKotlinContinuation, Drapi_libKotlinx_coroutines_core_nativeRunnable, Drapi_libKotlinSuspendFunction2, Drapi_libKotlinx_coroutines_core_nativeParentJob, Drapi_libKotlinx_coroutines_core_nativeSelectInstance, Drapi_libKotlinSuspendFunction0, Drapi_libKotlinKDeclarationContainer, Drapi_libKotlinKAnnotatedElement, Drapi_libKotlinKClassifier, Drapi_libKotlinSuspendFunction;

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
@interface Drapi_libMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((objc_runtime_name("KotlinMutableDictionary")))
__attribute__((swift_name("KotlinMutableDictionary")))
@interface Drapi_libMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((objc_runtime_name("KotlinNumber")))
__attribute__((swift_name("KotlinNumber")))
@interface Drapi_libNumber : NSNumber
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
@interface Drapi_libByte : Drapi_libNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((objc_runtime_name("KotlinUByte")))
__attribute__((swift_name("KotlinUByte")))
@interface Drapi_libUByte : Drapi_libNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((objc_runtime_name("KotlinShort")))
__attribute__((swift_name("KotlinShort")))
@interface Drapi_libShort : Drapi_libNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((objc_runtime_name("KotlinUShort")))
__attribute__((swift_name("KotlinUShort")))
@interface Drapi_libUShort : Drapi_libNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((objc_runtime_name("KotlinInt")))
__attribute__((swift_name("KotlinInt")))
@interface Drapi_libInt : Drapi_libNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((objc_runtime_name("KotlinUInt")))
__attribute__((swift_name("KotlinUInt")))
@interface Drapi_libUInt : Drapi_libNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((objc_runtime_name("KotlinLong")))
__attribute__((swift_name("KotlinLong")))
@interface Drapi_libLong : Drapi_libNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((objc_runtime_name("KotlinULong")))
__attribute__((swift_name("KotlinULong")))
@interface Drapi_libULong : Drapi_libNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((objc_runtime_name("KotlinFloat")))
__attribute__((swift_name("KotlinFloat")))
@interface Drapi_libFloat : Drapi_libNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((objc_runtime_name("KotlinDouble")))
__attribute__((swift_name("KotlinDouble")))
@interface Drapi_libDouble : Drapi_libNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((objc_runtime_name("KotlinBoolean")))
__attribute__((swift_name("KotlinBoolean")))
@interface Drapi_libBoolean : Drapi_libNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Date")))
@interface Drapi_libDate : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property int64_t time;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeSerializationStrategy")))
@protocol Drapi_libKotlinx_serialization_runtime_nativeSerializationStrategy
@required
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(id _Nullable)obj __attribute__((swift_name("serialize(output:obj:)")));
@property (readonly) id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor> descriptor;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeDeserializationStrategy")))
@protocol Drapi_libKotlinx_serialization_runtime_nativeDeserializationStrategy
@required
- (id _Nullable)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (id _Nullable)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(id _Nullable)old __attribute__((swift_name("patch(input:old:)")));
@property (readonly) id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor> descriptor;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeKSerializer")))
@protocol Drapi_libKotlinx_serialization_runtime_nativeKSerializer <Drapi_libKotlinx_serialization_runtime_nativeSerializationStrategy, Drapi_libKotlinx_serialization_runtime_nativeDeserializationStrategy>
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DateSerializer")))
@interface Drapi_libDateSerializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)dateSerializer __attribute__((swift_name("init()")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libDate *)obj __attribute__((swift_name("serialize(output:obj:)")));
- (Drapi_libDate *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libDate *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libDate *)old __attribute__((swift_name("patch(input:old:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchResult")))
@interface Drapi_libSearchResult : KotlinBase
- (instancetype)initWithTitle:(NSString *)Title Subtitle:(NSString *)Subtitle Description:(NSString *)Description IsRepremiere:(BOOL)IsRepremiere BundleType:(NSString *)BundleType ThemeType:(NSString *)ThemeType Slug:(NSString *)Slug Items:(NSArray<Drapi_libProgramCard *> *)Items Paging:(Drapi_libMuPaging *)Paging TotalSize:(int32_t)TotalSize BackgroundImageUri:(NSString *)BackgroundImageUri SiteUrl:(NSString *)SiteUrl __attribute__((swift_name("init(Title:Subtitle:Description:IsRepremiere:BundleType:ThemeType:Slug:Items:Paging:TotalSize:BackgroundImageUri:SiteUrl:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (BOOL)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (NSString *)component6 __attribute__((swift_name("component6()")));
- (NSString *)component7 __attribute__((swift_name("component7()")));
- (NSArray<Drapi_libProgramCard *> *)component8 __attribute__((swift_name("component8()")));
- (Drapi_libMuPaging *)component9 __attribute__((swift_name("component9()")));
- (int32_t)component10 __attribute__((swift_name("component10()")));
- (NSString *)component11 __attribute__((swift_name("component11()")));
- (NSString *)component12 __attribute__((swift_name("component12()")));
- (Drapi_libSearchResult *)doCopyTitle:(NSString *)Title Subtitle:(NSString *)Subtitle Description:(NSString *)Description IsRepremiere:(BOOL)IsRepremiere BundleType:(NSString *)BundleType ThemeType:(NSString *)ThemeType Slug:(NSString *)Slug Items:(NSArray<Drapi_libProgramCard *> *)Items Paging:(Drapi_libMuPaging *)Paging TotalSize:(int32_t)TotalSize BackgroundImageUri:(NSString *)BackgroundImageUri SiteUrl:(NSString *)SiteUrl __attribute__((swift_name("doCopy(Title:Subtitle:Description:IsRepremiere:BundleType:ThemeType:Slug:Items:Paging:TotalSize:BackgroundImageUri:SiteUrl:)")));
@property (readonly) NSString *Title;
@property (readonly) NSString *Subtitle;
@property (readonly) NSString *Description;
@property (readonly) BOOL IsRepremiere;
@property (readonly) NSString *BundleType;
@property (readonly) NSString *ThemeType;
@property (readonly) NSString *Slug;
@property (readonly) NSArray<Drapi_libProgramCard *> *Items;
@property (readonly) Drapi_libMuPaging *Paging;
@property (readonly) int32_t TotalSize;
@property (readonly) NSString *BackgroundImageUri;
@property (readonly) NSString *SiteUrl;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchResult.Companion")))
@interface Drapi_libSearchResultCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchResult.$serializer")))
@interface Drapi_libSearchResult$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libSearchResult *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libSearchResult *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libSearchResult *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libSearchResult *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuPaging")))
@interface Drapi_libMuPaging : KotlinBase
- (instancetype)initWithTitle:(NSString *)Title Source:(NSString *)Source Next:(NSString *)Next Previous:(NSString *)Previous TotalSize:(int32_t)TotalSize __attribute__((swift_name("init(Title:Source:Next:Previous:TotalSize:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (int32_t)component5 __attribute__((swift_name("component5()")));
- (Drapi_libMuPaging *)doCopyTitle:(NSString *)Title Source:(NSString *)Source Next:(NSString *)Next Previous:(NSString *)Previous TotalSize:(int32_t)TotalSize __attribute__((swift_name("doCopy(Title:Source:Next:Previous:TotalSize:)")));
@property (readonly) NSString *Title;
@property (readonly) NSString *Source;
@property (readonly) NSString *Next;
@property (readonly) NSString *Previous;
@property (readonly) int32_t TotalSize;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuPaging.Companion")))
@interface Drapi_libMuPagingCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuPaging.$serializer")))
@interface Drapi_libMuPaging$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libMuPaging *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libMuPaging *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libMuPaging *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libMuPaging *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Schedule")))
@interface Drapi_libSchedule : KotlinBase
- (instancetype)initWithBroadcasts:(NSArray<Drapi_libMuScheduleBroadcast *> *)Broadcasts BroadcastDate:(Drapi_libDate *)BroadcastDate ChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel __attribute__((swift_name("init(Broadcasts:BroadcastDate:ChannelSlug:Channel:)"))) __attribute__((objc_designated_initializer));
- (NSArray<Drapi_libMuScheduleBroadcast *> *)component1 __attribute__((swift_name("component1()")));
- (Drapi_libDate *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (Drapi_libSchedule *)doCopyBroadcasts:(NSArray<Drapi_libMuScheduleBroadcast *> *)Broadcasts BroadcastDate:(Drapi_libDate *)BroadcastDate ChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel __attribute__((swift_name("doCopy(Broadcasts:BroadcastDate:ChannelSlug:Channel:)")));
@property (readonly) NSArray<Drapi_libMuScheduleBroadcast *> *Broadcasts;
@property (readonly) Drapi_libDate *BroadcastDate;
@property (readonly) NSString *ChannelSlug;
@property (readonly) NSString *Channel;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Schedule.Companion")))
@interface Drapi_libScheduleCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Schedule.$serializer")))
@interface Drapi_libSchedule$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libSchedule *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libSchedule *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libSchedule *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libSchedule *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Channel")))
@interface Drapi_libChannel : KotlinBase
- (instancetype)initWithType:(NSString *)Type StreamingServers:(NSArray<Drapi_libMuStreamingServer *> *)StreamingServers Url:(NSString *)Url SourceUrl:(NSString *)SourceUrl WebChannel:(BOOL)WebChannel Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title ItemLabel:(NSString *)ItemLabel Subtitle:(NSString *)Subtitle __attribute__((swift_name("init(Type:StreamingServers:Url:SourceUrl:WebChannel:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:ItemLabel:Subtitle:)"))) __attribute__((objc_designated_initializer));
- (Drapi_libMuStreamingServer * _Nullable)server __attribute__((swift_name("server()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSArray<Drapi_libMuStreamingServer *> *)component2 __attribute__((swift_name("component2()")));
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
- (Drapi_libChannel *)doCopyType:(NSString *)Type StreamingServers:(NSArray<Drapi_libMuStreamingServer *> *)StreamingServers Url:(NSString *)Url SourceUrl:(NSString *)SourceUrl WebChannel:(BOOL)WebChannel Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title ItemLabel:(NSString *)ItemLabel Subtitle:(NSString *)Subtitle __attribute__((swift_name("doCopy(Type:StreamingServers:Url:SourceUrl:WebChannel:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:ItemLabel:Subtitle:)")));
@property (readonly) NSString *Type;
@property (readonly) NSArray<Drapi_libMuStreamingServer *> *StreamingServers;
@property (readonly) NSString *Url;
@property (readonly) NSString *SourceUrl;
@property (readonly) BOOL WebChannel;
@property (readonly) NSString *Slug;
@property (readonly) NSString *Urn;
@property (readonly) NSString *PrimaryImageUri;
@property (readonly) NSString *PresentationUri;
@property (readonly) NSString *PresentationUriAutoplay;
@property (readonly) NSString *Title;
@property (readonly) NSString *ItemLabel;
@property (readonly) NSString *Subtitle;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Channel.Companion")))
@interface Drapi_libChannelCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Channel.$serializer")))
@interface Drapi_libChannel$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libChannel *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libChannel *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libChannel *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libChannel *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamingServer")))
@interface Drapi_libMuStreamingServer : KotlinBase
- (instancetype)initWithServer:(NSString *)Server LinkType:(NSString *)LinkType Qualities:(NSArray<Drapi_libMuStreamQuality *> *)Qualities DynamicUserQualityChange:(BOOL)DynamicUserQualityChange EncryptedServer:(NSString *)EncryptedServer __attribute__((swift_name("init(Server:LinkType:Qualities:DynamicUserQualityChange:EncryptedServer:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSArray<Drapi_libMuStreamQuality *> *)component3 __attribute__((swift_name("component3()")));
- (BOOL)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (Drapi_libMuStreamingServer *)doCopyServer:(NSString *)Server LinkType:(NSString *)LinkType Qualities:(NSArray<Drapi_libMuStreamQuality *> *)Qualities DynamicUserQualityChange:(BOOL)DynamicUserQualityChange EncryptedServer:(NSString *)EncryptedServer __attribute__((swift_name("doCopy(Server:LinkType:Qualities:DynamicUserQualityChange:EncryptedServer:)")));
@property (readonly) NSString *Server;
@property (readonly) NSString *LinkType;
@property (readonly) NSArray<Drapi_libMuStreamQuality *> *Qualities;
@property (readonly) BOOL DynamicUserQualityChange;
@property (readonly) NSString *EncryptedServer;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamingServer.Companion")))
@interface Drapi_libMuStreamingServerCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamingServer.$serializer")))
@interface Drapi_libMuStreamingServer$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libMuStreamingServer *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libMuStreamingServer *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libMuStreamingServer *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libMuStreamingServer *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamQuality")))
@interface Drapi_libMuStreamQuality : KotlinBase
- (instancetype)initWithKbps:(int32_t)Kbps Streams:(NSArray<Drapi_libMuStream *> *)Streams __attribute__((swift_name("init(Kbps:Streams:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSArray<Drapi_libMuStream *> *)component2 __attribute__((swift_name("component2()")));
- (Drapi_libMuStreamQuality *)doCopyKbps:(int32_t)Kbps Streams:(NSArray<Drapi_libMuStream *> *)Streams __attribute__((swift_name("doCopy(Kbps:Streams:)")));
@property (readonly) int32_t Kbps;
@property (readonly) NSArray<Drapi_libMuStream *> *Streams;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamQuality.Companion")))
@interface Drapi_libMuStreamQualityCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamQuality.$serializer")))
@interface Drapi_libMuStreamQuality$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libMuStreamQuality *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libMuStreamQuality *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libMuStreamQuality *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libMuStreamQuality *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStream")))
@interface Drapi_libMuStream : KotlinBase
- (instancetype)initWithStream:(NSString *)Stream EncryptedStream:(NSString *)EncryptedStream __attribute__((swift_name("init(Stream:EncryptedStream:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (Drapi_libMuStream *)doCopyStream:(NSString *)Stream EncryptedStream:(NSString *)EncryptedStream __attribute__((swift_name("doCopy(Stream:EncryptedStream:)")));
@property (readonly) NSString *Stream;
@property (readonly) NSString *EncryptedStream;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStream.Companion")))
@interface Drapi_libMuStreamCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStream.$serializer")))
@interface Drapi_libMuStream$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libMuStream *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libMuStream *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libMuStream *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libMuStream *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuNowNext")))
@interface Drapi_libMuNowNext : KotlinBase
- (instancetype)initWithChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel Now:(Drapi_libMuScheduleBroadcast * _Nullable)Now Next:(NSArray<Drapi_libMuScheduleBroadcast *> *)Next __attribute__((swift_name("init(ChannelSlug:Channel:Now:Next:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (Drapi_libMuScheduleBroadcast * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSArray<Drapi_libMuScheduleBroadcast *> *)component4 __attribute__((swift_name("component4()")));
- (Drapi_libMuNowNext *)doCopyChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel Now:(Drapi_libMuScheduleBroadcast * _Nullable)Now Next:(NSArray<Drapi_libMuScheduleBroadcast *> *)Next __attribute__((swift_name("doCopy(ChannelSlug:Channel:Now:Next:)")));
@property (readonly) NSString *ChannelSlug;
@property (readonly) NSString *Channel;
@property (readonly) Drapi_libMuScheduleBroadcast * _Nullable Now;
@property (readonly) NSArray<Drapi_libMuScheduleBroadcast *> *Next;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuNowNext.Companion")))
@interface Drapi_libMuNowNextCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuNowNext.$serializer")))
@interface Drapi_libMuNowNext$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libMuNowNext *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libMuNowNext *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libMuNowNext *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libMuNowNext *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuScheduleBroadcast")))
@interface Drapi_libMuScheduleBroadcast : KotlinBase
- (instancetype)initWithTitle:(NSString *)Title Description:(NSString *)Description Subtitle:(NSString *)Subtitle StartTime:(Drapi_libDate *)StartTime EndTime:(Drapi_libDate *)EndTime ProgramCard:(Drapi_libProgramCard *)ProgramCard OnlineGenreText:(NSString * _Nullable)OnlineGenreText ProductionNumber:(NSString *)ProductionNumber ProgramCardHasPrimaryAsset:(BOOL)ProgramCardHasPrimaryAsset SeriesHasProgramCardWithPrimaryAsset:(BOOL)SeriesHasProgramCardWithPrimaryAsset AnnouncedStartTime:(Drapi_libDate *)AnnouncedStartTime AnnouncedEndTime:(Drapi_libDate *)AnnouncedEndTime ProductionCountry:(NSString *)ProductionCountry ProductionYear:(int32_t)ProductionYear VideoWidescreen:(BOOL)VideoWidescreen SubtitlesTTV:(BOOL)SubtitlesTTV VideoHD:(BOOL)VideoHD WhatsOnUri:(NSString *)WhatsOnUri IsRerun:(BOOL)IsRerun __attribute__((swift_name("init(Title:Description:Subtitle:StartTime:EndTime:ProgramCard:OnlineGenreText:ProductionNumber:ProgramCardHasPrimaryAsset:SeriesHasProgramCardWithPrimaryAsset:AnnouncedStartTime:AnnouncedEndTime:ProductionCountry:ProductionYear:VideoWidescreen:SubtitlesTTV:VideoHD:WhatsOnUri:IsRerun:)"))) __attribute__((objc_designated_initializer));
- (NSString * _Nullable)getPrimaryAssetUri __attribute__((swift_name("getPrimaryAssetUri()")));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (Drapi_libDate *)component4 __attribute__((swift_name("component4()")));
- (Drapi_libDate *)component5 __attribute__((swift_name("component5()")));
- (Drapi_libProgramCard *)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (NSString *)component8 __attribute__((swift_name("component8()")));
- (BOOL)component9 __attribute__((swift_name("component9()")));
- (BOOL)component10 __attribute__((swift_name("component10()")));
- (Drapi_libDate *)component11 __attribute__((swift_name("component11()")));
- (Drapi_libDate *)component12 __attribute__((swift_name("component12()")));
- (NSString *)component13 __attribute__((swift_name("component13()")));
- (int32_t)component14 __attribute__((swift_name("component14()")));
- (BOOL)component15 __attribute__((swift_name("component15()")));
- (BOOL)component16 __attribute__((swift_name("component16()")));
- (BOOL)component17 __attribute__((swift_name("component17()")));
- (NSString *)component18 __attribute__((swift_name("component18()")));
- (BOOL)component19 __attribute__((swift_name("component19()")));
- (Drapi_libMuScheduleBroadcast *)doCopyTitle:(NSString *)Title Description:(NSString *)Description Subtitle:(NSString *)Subtitle StartTime:(Drapi_libDate *)StartTime EndTime:(Drapi_libDate *)EndTime ProgramCard:(Drapi_libProgramCard *)ProgramCard OnlineGenreText:(NSString * _Nullable)OnlineGenreText ProductionNumber:(NSString *)ProductionNumber ProgramCardHasPrimaryAsset:(BOOL)ProgramCardHasPrimaryAsset SeriesHasProgramCardWithPrimaryAsset:(BOOL)SeriesHasProgramCardWithPrimaryAsset AnnouncedStartTime:(Drapi_libDate *)AnnouncedStartTime AnnouncedEndTime:(Drapi_libDate *)AnnouncedEndTime ProductionCountry:(NSString *)ProductionCountry ProductionYear:(int32_t)ProductionYear VideoWidescreen:(BOOL)VideoWidescreen SubtitlesTTV:(BOOL)SubtitlesTTV VideoHD:(BOOL)VideoHD WhatsOnUri:(NSString *)WhatsOnUri IsRerun:(BOOL)IsRerun __attribute__((swift_name("doCopy(Title:Description:Subtitle:StartTime:EndTime:ProgramCard:OnlineGenreText:ProductionNumber:ProgramCardHasPrimaryAsset:SeriesHasProgramCardWithPrimaryAsset:AnnouncedStartTime:AnnouncedEndTime:ProductionCountry:ProductionYear:VideoWidescreen:SubtitlesTTV:VideoHD:WhatsOnUri:IsRerun:)")));
@property (readonly) NSString *Title;
@property (readonly) NSString *Description;
@property (readonly) NSString *Subtitle;
@property (readonly) Drapi_libDate *StartTime;
@property (readonly) Drapi_libDate *EndTime;
@property (readonly) Drapi_libProgramCard *ProgramCard;
@property (readonly) NSString * _Nullable OnlineGenreText;
@property (readonly) NSString *ProductionNumber;
@property (readonly) BOOL ProgramCardHasPrimaryAsset;
@property (readonly) BOOL SeriesHasProgramCardWithPrimaryAsset;
@property (readonly) Drapi_libDate *AnnouncedStartTime;
@property (readonly) Drapi_libDate *AnnouncedEndTime;
@property (readonly) NSString *ProductionCountry;
@property (readonly) int32_t ProductionYear;
@property (readonly) BOOL VideoWidescreen;
@property (readonly) BOOL SubtitlesTTV;
@property (readonly) BOOL VideoHD;
@property (readonly) NSString *WhatsOnUri;
@property (readonly) BOOL IsRerun;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuScheduleBroadcast.Companion")))
@interface Drapi_libMuScheduleBroadcastCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuScheduleBroadcast.$serializer")))
@interface Drapi_libMuScheduleBroadcast$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libMuScheduleBroadcast *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libMuScheduleBroadcast *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libMuScheduleBroadcast *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libMuScheduleBroadcast *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProgramCard")))
@interface Drapi_libProgramCard : KotlinBase
- (instancetype)initWithType:(NSString *)Type SeriesTitle:(NSString *)SeriesTitle EpisodeTitle:(NSString *)EpisodeTitle SeriesSlug:(NSString *)SeriesSlug SeriesUrn:(NSString *)SeriesUrn HostName:(NSString *)HostName SeriesHostName:(NSString *)SeriesHostName PrimaryChannel:(NSString *)PrimaryChannel PrimaryChannelSlug:(NSString *)PrimaryChannelSlug SeasonEpisodeNumberingValid:(BOOL)SeasonEpisodeNumberingValid SeasonTitle:(NSString * _Nullable)SeasonTitle SeasonSlug:(NSString * _Nullable)SeasonSlug SeasonUrn:(NSString * _Nullable)SeasonUrn SeasonNumber:(int32_t)SeasonNumber PrePremiere:(BOOL)PrePremiere ExpiresSoon:(BOOL)ExpiresSoon OnlineGenreText:(NSString *)OnlineGenreText PrimaryAsset:(Drapi_libPrimaryAsset * _Nullable)PrimaryAsset HasPublicPrimaryAsset:(BOOL)HasPublicPrimaryAsset AssetTargetTypes:(NSString *)AssetTargetTypes PrimaryBroadcastStartTime:(Drapi_libDate * _Nullable)PrimaryBroadcastStartTime SortDateTime:(Drapi_libDate *)SortDateTime OnDemandInfo:(Drapi_libInfo * _Nullable)OnDemandInfo Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title Subtitle:(NSString *)Subtitle IsNewSeries:(BOOL)IsNewSeries OriginalTitle:(NSString *)OriginalTitle __attribute__((swift_name("init(Type:SeriesTitle:EpisodeTitle:SeriesSlug:SeriesUrn:HostName:SeriesHostName:PrimaryChannel:PrimaryChannelSlug:SeasonEpisodeNumberingValid:SeasonTitle:SeasonSlug:SeasonUrn:SeasonNumber:PrePremiere:ExpiresSoon:OnlineGenreText:PrimaryAsset:HasPublicPrimaryAsset:AssetTargetTypes:PrimaryBroadcastStartTime:SortDateTime:OnDemandInfo:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:Subtitle:IsNewSeries:OriginalTitle:)"))) __attribute__((objc_designated_initializer));
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
- (Drapi_libPrimaryAsset * _Nullable)component18 __attribute__((swift_name("component18()")));
- (BOOL)component19 __attribute__((swift_name("component19()")));
- (NSString *)component20 __attribute__((swift_name("component20()")));
- (Drapi_libDate * _Nullable)component21 __attribute__((swift_name("component21()")));
- (Drapi_libDate *)component22 __attribute__((swift_name("component22()")));
- (Drapi_libInfo * _Nullable)component23 __attribute__((swift_name("component23()")));
- (NSString *)component24 __attribute__((swift_name("component24()")));
- (NSString *)component25 __attribute__((swift_name("component25()")));
- (NSString *)component26 __attribute__((swift_name("component26()")));
- (NSString *)component27 __attribute__((swift_name("component27()")));
- (NSString *)component28 __attribute__((swift_name("component28()")));
- (NSString *)component29 __attribute__((swift_name("component29()")));
- (NSString *)component30 __attribute__((swift_name("component30()")));
- (BOOL)component31 __attribute__((swift_name("component31()")));
- (NSString *)component32 __attribute__((swift_name("component32()")));
- (Drapi_libProgramCard *)doCopyType:(NSString *)Type SeriesTitle:(NSString *)SeriesTitle EpisodeTitle:(NSString *)EpisodeTitle SeriesSlug:(NSString *)SeriesSlug SeriesUrn:(NSString *)SeriesUrn HostName:(NSString *)HostName SeriesHostName:(NSString *)SeriesHostName PrimaryChannel:(NSString *)PrimaryChannel PrimaryChannelSlug:(NSString *)PrimaryChannelSlug SeasonEpisodeNumberingValid:(BOOL)SeasonEpisodeNumberingValid SeasonTitle:(NSString * _Nullable)SeasonTitle SeasonSlug:(NSString * _Nullable)SeasonSlug SeasonUrn:(NSString * _Nullable)SeasonUrn SeasonNumber:(int32_t)SeasonNumber PrePremiere:(BOOL)PrePremiere ExpiresSoon:(BOOL)ExpiresSoon OnlineGenreText:(NSString *)OnlineGenreText PrimaryAsset:(Drapi_libPrimaryAsset * _Nullable)PrimaryAsset HasPublicPrimaryAsset:(BOOL)HasPublicPrimaryAsset AssetTargetTypes:(NSString *)AssetTargetTypes PrimaryBroadcastStartTime:(Drapi_libDate * _Nullable)PrimaryBroadcastStartTime SortDateTime:(Drapi_libDate *)SortDateTime OnDemandInfo:(Drapi_libInfo * _Nullable)OnDemandInfo Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title Subtitle:(NSString *)Subtitle IsNewSeries:(BOOL)IsNewSeries OriginalTitle:(NSString *)OriginalTitle __attribute__((swift_name("doCopy(Type:SeriesTitle:EpisodeTitle:SeriesSlug:SeriesUrn:HostName:SeriesHostName:PrimaryChannel:PrimaryChannelSlug:SeasonEpisodeNumberingValid:SeasonTitle:SeasonSlug:SeasonUrn:SeasonNumber:PrePremiere:ExpiresSoon:OnlineGenreText:PrimaryAsset:HasPublicPrimaryAsset:AssetTargetTypes:PrimaryBroadcastStartTime:SortDateTime:OnDemandInfo:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:Subtitle:IsNewSeries:OriginalTitle:)")));
@property (readonly) NSString *Type;
@property (readonly) NSString *SeriesTitle;
@property (readonly) NSString *EpisodeTitle;
@property (readonly) NSString *SeriesSlug;
@property (readonly) NSString *SeriesUrn;
@property (readonly) NSString *HostName;
@property (readonly) NSString *SeriesHostName;
@property (readonly) NSString *PrimaryChannel;
@property (readonly) NSString *PrimaryChannelSlug;
@property (readonly) BOOL SeasonEpisodeNumberingValid;
@property (readonly) NSString * _Nullable SeasonTitle;
@property (readonly) NSString * _Nullable SeasonSlug;
@property (readonly) NSString * _Nullable SeasonUrn;
@property (readonly) int32_t SeasonNumber;
@property (readonly) BOOL PrePremiere;
@property (readonly) BOOL ExpiresSoon;
@property (readonly) NSString *OnlineGenreText;
@property (readonly) Drapi_libPrimaryAsset * _Nullable PrimaryAsset;
@property (readonly) BOOL HasPublicPrimaryAsset;
@property (readonly) NSString *AssetTargetTypes;
@property (readonly) Drapi_libDate * _Nullable PrimaryBroadcastStartTime;
@property (readonly) Drapi_libDate *SortDateTime;
@property (readonly) Drapi_libInfo * _Nullable OnDemandInfo;
@property (readonly) NSString *Slug;
@property (readonly) NSString *Urn;
@property (readonly) NSString *PrimaryImageUri;
@property (readonly) NSString *PresentationUri;
@property (readonly) NSString *PresentationUriAutoplay;
@property (readonly) NSString *Title;
@property (readonly) NSString *Subtitle;
@property (readonly) BOOL IsNewSeries;
@property (readonly) NSString *OriginalTitle;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProgramCard.Companion")))
@interface Drapi_libProgramCardCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProgramCard.$serializer")))
@interface Drapi_libProgramCard$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libProgramCard *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libProgramCard *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libProgramCard *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libProgramCard *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Info")))
@interface Drapi_libInfo : KotlinBase
- (instancetype)initWithStartPublish:(Drapi_libDate *)StartPublish EndPublish:(Drapi_libDate *)EndPublish __attribute__((swift_name("init(StartPublish:EndPublish:)"))) __attribute__((objc_designated_initializer));
- (Drapi_libDate *)component1 __attribute__((swift_name("component1()")));
- (Drapi_libDate *)component2 __attribute__((swift_name("component2()")));
- (Drapi_libInfo *)doCopyStartPublish:(Drapi_libDate *)StartPublish EndPublish:(Drapi_libDate *)EndPublish __attribute__((swift_name("doCopy(StartPublish:EndPublish:)")));
@property (readonly) Drapi_libDate *StartPublish;
@property (readonly) Drapi_libDate *EndPublish;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Info.Companion")))
@interface Drapi_libInfoCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Info.$serializer")))
@interface Drapi_libInfo$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libInfo *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libInfo *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libInfo *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libInfo *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PrimaryAsset")))
@interface Drapi_libPrimaryAsset : KotlinBase
- (instancetype)initWithKind:(NSString *)Kind Uri:(NSString *)Uri DurationInMilliseconds:(int64_t)DurationInMilliseconds Downloadable:(BOOL)Downloadable RestrictedToDenmark:(BOOL)RestrictedToDenmark StartPublish:(Drapi_libDate *)StartPublish EndPublish:(Drapi_libDate *)EndPublish Target:(NSString *)Target Encrypted:(BOOL)Encrypted IsLiveStream:(BOOL)IsLiveStream __attribute__((swift_name("init(Kind:Uri:DurationInMilliseconds:Downloadable:RestrictedToDenmark:StartPublish:EndPublish:Target:Encrypted:IsLiveStream:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (int64_t)component3 __attribute__((swift_name("component3()")));
- (BOOL)component4 __attribute__((swift_name("component4()")));
- (BOOL)component5 __attribute__((swift_name("component5()")));
- (Drapi_libDate *)component6 __attribute__((swift_name("component6()")));
- (Drapi_libDate *)component7 __attribute__((swift_name("component7()")));
- (NSString *)component8 __attribute__((swift_name("component8()")));
- (BOOL)component9 __attribute__((swift_name("component9()")));
- (BOOL)component10 __attribute__((swift_name("component10()")));
- (Drapi_libPrimaryAsset *)doCopyKind:(NSString *)Kind Uri:(NSString *)Uri DurationInMilliseconds:(int64_t)DurationInMilliseconds Downloadable:(BOOL)Downloadable RestrictedToDenmark:(BOOL)RestrictedToDenmark StartPublish:(Drapi_libDate *)StartPublish EndPublish:(Drapi_libDate *)EndPublish Target:(NSString *)Target Encrypted:(BOOL)Encrypted IsLiveStream:(BOOL)IsLiveStream __attribute__((swift_name("doCopy(Kind:Uri:DurationInMilliseconds:Downloadable:RestrictedToDenmark:StartPublish:EndPublish:Target:Encrypted:IsLiveStream:)")));
@property (readonly) NSString *Kind;
@property (readonly) NSString *Uri;
@property (readonly) int64_t DurationInMilliseconds;
@property (readonly) BOOL Downloadable;
@property (readonly) BOOL RestrictedToDenmark;
@property (readonly) Drapi_libDate *StartPublish;
@property (readonly) Drapi_libDate *EndPublish;
@property (readonly) NSString *Target;
@property (readonly) BOOL Encrypted;
@property (readonly) BOOL IsLiveStream;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PrimaryAsset.Companion")))
@interface Drapi_libPrimaryAssetCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PrimaryAsset.$serializer")))
@interface Drapi_libPrimaryAsset$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libPrimaryAsset *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libPrimaryAsset *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libPrimaryAsset *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libPrimaryAsset *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Manifest")))
@interface Drapi_libManifest : KotlinBase
- (instancetype)initWithLinks:(NSArray<Drapi_libLink *> *)Links SubtitlesList:(NSArray<Drapi_libSubtitle *> *)SubtitlesList __attribute__((swift_name("init(Links:SubtitlesList:)"))) __attribute__((objc_designated_initializer));
- (NSString * _Nullable)getUri __attribute__((swift_name("getUri()")));
- (NSArray<Drapi_libLink *> *)component1 __attribute__((swift_name("component1()")));
- (NSArray<Drapi_libSubtitle *> *)component2 __attribute__((swift_name("component2()")));
- (Drapi_libManifest *)doCopyLinks:(NSArray<Drapi_libLink *> *)Links SubtitlesList:(NSArray<Drapi_libSubtitle *> *)SubtitlesList __attribute__((swift_name("doCopy(Links:SubtitlesList:)")));
@property (readonly) NSArray<Drapi_libLink *> *Links;
@property (readonly) NSArray<Drapi_libSubtitle *> *SubtitlesList;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Manifest.Companion")))
@interface Drapi_libManifestCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Manifest.$serializer")))
@interface Drapi_libManifest$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libManifest *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libManifest *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libManifest *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libManifest *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Link")))
@interface Drapi_libLink : KotlinBase
- (instancetype)initWithHardSubtitlesType:(NSString *)HardSubtitlesType Uri:(NSString *)Uri EncryptedUri:(NSString *)EncryptedUri FileFormat:(NSString *)FileFormat Target:(NSString *)Target Bitrate:(int32_t)Bitrate __attribute__((swift_name("init(HardSubtitlesType:Uri:EncryptedUri:FileFormat:Target:Bitrate:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (int32_t)component6 __attribute__((swift_name("component6()")));
- (Drapi_libLink *)doCopyHardSubtitlesType:(NSString *)HardSubtitlesType Uri:(NSString *)Uri EncryptedUri:(NSString *)EncryptedUri FileFormat:(NSString *)FileFormat Target:(NSString *)Target Bitrate:(int32_t)Bitrate __attribute__((swift_name("doCopy(HardSubtitlesType:Uri:EncryptedUri:FileFormat:Target:Bitrate:)")));
@property (readonly) NSString *HardSubtitlesType;
@property (readonly) NSString *Uri;
@property (readonly) NSString *EncryptedUri;
@property (readonly) NSString *FileFormat;
@property (readonly) NSString *Target;
@property (readonly) int32_t Bitrate;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Link.Companion")))
@interface Drapi_libLinkCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Link.$serializer")))
@interface Drapi_libLink$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libLink *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libLink *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libLink *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libLink *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Subtitle")))
@interface Drapi_libSubtitle : KotlinBase
- (instancetype)initWithLanguage:(NSString *)Language MimeType:(NSString *)MimeType Type:(NSString *)Type Uri:(NSString *)Uri __attribute__((swift_name("init(Language:MimeType:Type:Uri:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (Drapi_libSubtitle *)doCopyLanguage:(NSString *)Language MimeType:(NSString *)MimeType Type:(NSString *)Type Uri:(NSString *)Uri __attribute__((swift_name("doCopy(Language:MimeType:Type:Uri:)")));
@property (readonly) NSString *Language;
@property (readonly) NSString *MimeType;
@property (readonly) NSString *Type;
@property (readonly) NSString *Uri;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Subtitle.Companion")))
@interface Drapi_libSubtitleCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Subtitle.$serializer")))
@interface Drapi_libSubtitle$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libSubtitle *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libSubtitle *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libSubtitle *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libSubtitle *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MostViewed")))
@interface Drapi_libMostViewed : KotlinBase
- (instancetype)initWithItems:(NSArray<Drapi_libProgramCard *> *)Items Paging:(Drapi_libMuPaging *)Paging TotalSize:(int32_t)TotalSize __attribute__((swift_name("init(Items:Paging:TotalSize:)"))) __attribute__((objc_designated_initializer));
- (NSArray<Drapi_libProgramCard *> *)component1 __attribute__((swift_name("component1()")));
- (Drapi_libMuPaging *)component2 __attribute__((swift_name("component2()")));
- (int32_t)component3 __attribute__((swift_name("component3()")));
- (Drapi_libMostViewed *)doCopyItems:(NSArray<Drapi_libProgramCard *> *)Items Paging:(Drapi_libMuPaging *)Paging TotalSize:(int32_t)TotalSize __attribute__((swift_name("doCopy(Items:Paging:TotalSize:)")));
@property (readonly) NSArray<Drapi_libProgramCard *> *Items;
@property (readonly) Drapi_libMuPaging *Paging;
@property (readonly) int32_t TotalSize;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MostViewed.Companion")))
@interface Drapi_libMostViewedCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MostViewed.$serializer")))
@interface Drapi_libMostViewed$serializer : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (Drapi_libMostViewed *)deserializeInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input __attribute__((swift_name("deserialize(input:)")));
- (Drapi_libMostViewed *)patchInput:(id<Drapi_libKotlinx_serialization_runtime_nativeDecoder>)input old:(Drapi_libMostViewed *)old __attribute__((swift_name("patch(input:old:)")));
- (void)serializeOutput:(id<Drapi_libKotlinx_serialization_runtime_nativeEncoder>)output obj:(Drapi_libMostViewed *)obj __attribute__((swift_name("serialize(output:obj:)")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface Drapi_libKotlinThrowable : KotlinBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (Drapi_libKotlinArray *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
@property (readonly) Drapi_libKotlinThrowable * _Nullable cause;
@property (readonly) NSString * _Nullable message;
@end;

__attribute__((swift_name("KotlinException")))
@interface Drapi_libKotlinException : Drapi_libKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrMuException")))
@interface Drapi_libDrMuException : Drapi_libKotlinException
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithCause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((swift_name("DrMuRepository")))
@interface Drapi_libDrMuRepository : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (BOOL)equalsOther:(id _Nullable)other __attribute__((swift_name("equals(other:)")));
- (int32_t)hashCode __attribute__((swift_name("hashCode()")));
- (NSString *)toString __attribute__((swift_name("toString()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HttpClientFactory")))
@interface Drapi_libHttpClientFactory : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)httpClientFactory __attribute__((swift_name("init()")));
- (Drapi_libKtor_client_core_iosHttpClient *)create __attribute__((swift_name("create()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeCoroutineScope")))
@protocol Drapi_libKotlinx_coroutines_core_nativeCoroutineScope
@required
@property (readonly) id<Drapi_libKotlinCoroutineContext> coroutineContext;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrMuRepositoryCallback")))
@interface Drapi_libDrMuRepositoryCallback : Drapi_libDrMuRepository <Drapi_libKotlinx_coroutines_core_nativeCoroutineScope>
- (instancetype)initWithCoroutineContext:(id<Drapi_libKotlinCoroutineContext>)coroutineContext __attribute__((swift_name("init(coroutineContext:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (id<Drapi_libKotlinx_coroutines_core_nativeJob>)getAllActiveDrTvChannelsCallback:(Drapi_libKotlinUnit *(^)(NSArray<Drapi_libChannel *> *))callback __attribute__((swift_name("getAllActiveDrTvChannels(callback:)")));
- (id<Drapi_libKotlinx_coroutines_core_nativeJob>)getManifestUri:(NSString *)uri callback:(Drapi_libKotlinUnit *(^)(Drapi_libManifest *))callback __attribute__((swift_name("getManifest(uri:callback:)")));
- (id<Drapi_libKotlinx_coroutines_core_nativeJob>)getScheduleId:(NSString *)id date:(NSString *)date callback:(Drapi_libKotlinUnit *(^)(Drapi_libSchedule *))callback __attribute__((swift_name("getSchedule(id:date:callback:)")));
- (id<Drapi_libKotlinx_coroutines_core_nativeJob>)getScheduleNowNextId:(NSString *)id callback:(Drapi_libKotlinUnit *(^)(Drapi_libMuNowNext *))callback __attribute__((swift_name("getScheduleNowNext(id:callback:)")));
- (id<Drapi_libKotlinx_coroutines_core_nativeJob>)getScheduleNowNextCallback:(Drapi_libKotlinUnit *(^)(NSArray<Drapi_libMuNowNext *> *))callback __attribute__((swift_name("getScheduleNowNext(callback:)")));
- (id<Drapi_libKotlinx_coroutines_core_nativeJob>)searchQuery:(NSString *)query callback:(Drapi_libKotlinUnit *(^)(Drapi_libSearchResult *))callback __attribute__((swift_name("search(query:callback:)")));
- (id<Drapi_libKotlinx_coroutines_core_nativeJob>)getMostViewedChannel:(NSString *)channel channelType:(NSString *)channelType limit:(int32_t)limit callback:(Drapi_libKotlinUnit *(^)(Drapi_libMostViewed *))callback __attribute__((swift_name("getMostViewed(channel:channelType:limit:callback:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrMuApiKt")))
@interface Drapi_libDrMuApiKt : KotlinBase
@property (class, readonly) NSString *API_VERSION;
@property (class, readonly) NSString *API_URL;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeEncoder")))
@protocol Drapi_libKotlinx_serialization_runtime_nativeEncoder
@required
- (id<Drapi_libKotlinx_serialization_runtime_nativeCompositeEncoder>)beginCollectionDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc collectionSize:(int32_t)collectionSize typeParams:(Drapi_libKotlinArray *)typeParams __attribute__((swift_name("beginCollection(desc:collectionSize:typeParams:)")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeCompositeEncoder>)beginStructureDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc typeParams:(Drapi_libKotlinArray *)typeParams __attribute__((swift_name("beginStructure(desc:typeParams:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescription:(Drapi_libKotlinx_serialization_runtime_nativeEnumDescriptor *)enumDescription ordinal:(int32_t)ordinal __attribute__((swift_name("encodeEnum(enumDescription:ordinal:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));
- (void)encodeNull __attribute__((swift_name("encodeNull()")));
- (void)encodeNullableSerializableValueSaver:(id<Drapi_libKotlinx_serialization_runtime_nativeSerializationStrategy>)saver value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(saver:value:)")));
- (void)encodeSerializableValueSaver:(id<Drapi_libKotlinx_serialization_runtime_nativeSerializationStrategy>)saver value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(saver:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
- (void)encodeUnit __attribute__((swift_name("encodeUnit()")));
@property (readonly) id<Drapi_libKotlinx_serialization_runtime_nativeSerialContext> context;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeSerialDescriptor")))
@protocol Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor
@required
- (NSArray<id<Drapi_libKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));
- (NSArray<id<Drapi_libKotlinAnnotation>> *)getEntityAnnotations __attribute__((swift_name("getEntityAnnotations()")));
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));
@property (readonly) int32_t elementsCount;
@property (readonly) BOOL isNullable;
@property (readonly) Drapi_libKotlinx_serialization_runtime_nativeSerialKind *kind;
@property (readonly) NSString *name;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeDecoder")))
@protocol Drapi_libKotlinx_serialization_runtime_nativeDecoder
@required
- (id<Drapi_libKotlinx_serialization_runtime_nativeCompositeDecoder>)beginStructureDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc typeParams:(Drapi_libKotlinArray *)typeParams __attribute__((swift_name("beginStructure(desc:typeParams:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescription:(Drapi_libKotlinx_serialization_runtime_nativeEnumDescriptor *)enumDescription __attribute__((swift_name("decodeEnum(enumDescription:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));
- (Drapi_libKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));
- (id _Nullable)decodeNullableSerializableValueLoader:(id<Drapi_libKotlinx_serialization_runtime_nativeDeserializationStrategy>)loader __attribute__((swift_name("decodeNullableSerializableValue(loader:)")));
- (id _Nullable)decodeSerializableValueLoader:(id<Drapi_libKotlinx_serialization_runtime_nativeDeserializationStrategy>)loader __attribute__((swift_name("decodeSerializableValue(loader:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
- (void)decodeUnit __attribute__((swift_name("decodeUnit()")));
- (id _Nullable)updateNullableSerializableValueLoader:(id<Drapi_libKotlinx_serialization_runtime_nativeDeserializationStrategy>)loader old:(id _Nullable)old __attribute__((swift_name("updateNullableSerializableValue(loader:old:)")));
- (id _Nullable)updateSerializableValueLoader:(id<Drapi_libKotlinx_serialization_runtime_nativeDeserializationStrategy>)loader old:(id _Nullable)old __attribute__((swift_name("updateSerializableValue(loader:old:)")));
@property (readonly) id<Drapi_libKotlinx_serialization_runtime_nativeSerialContext> context;
@property (readonly) Drapi_libKotlinx_serialization_runtime_nativeUpdateMode *updateMode;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface Drapi_libKotlinArray : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size init:(id _Nullable (^)(Drapi_libInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (id _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<Drapi_libKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(id _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size;
@end;

__attribute__((swift_name("Kotlinx_io_nativeCloseable")))
@protocol Drapi_libKotlinx_io_nativeCloseable
@required
- (void)close __attribute__((swift_name("close()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_core_iosHttpClient")))
@interface Drapi_libKtor_client_core_iosHttpClient : KotlinBase <Drapi_libKotlinx_coroutines_core_nativeCoroutineScope, Drapi_libKotlinx_io_nativeCloseable>
- (instancetype)initWithEngine:(id<Drapi_libKtor_client_core_iosHttpClientEngine>)engine userConfig:(Drapi_libKtor_client_core_iosHttpClientConfig *)userConfig __attribute__((swift_name("init(engine:userConfig:)"))) __attribute__((objc_designated_initializer));
- (Drapi_libKtor_client_core_iosHttpClient *)configBlock:(Drapi_libKotlinUnit *(^)(Drapi_libKtor_client_core_iosHttpClientConfig *))block __attribute__((swift_name("config(block:)")));
@property (readonly) id<Drapi_libKtor_utils_iosAttributes> attributes;
@property (readonly) Drapi_libKotlinx_coroutines_core_nativeCoroutineDispatcher *dispatcher;
@property (readonly) Drapi_libKtor_client_core_iosHttpClientEngineConfig *engineConfig;
@property (readonly) Drapi_libKtor_client_core_iosHttpReceivePipeline *receivePipeline;
@property (readonly) Drapi_libKtor_client_core_iosHttpRequestPipeline *requestPipeline;
@property (readonly) Drapi_libKtor_client_core_iosHttpResponsePipeline *responsePipeline;
@property (readonly) Drapi_libKtor_client_core_iosHttpSendPipeline *sendPipeline;
@end;

__attribute__((swift_name("KotlinCoroutineContext")))
@protocol Drapi_libKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<Drapi_libKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<Drapi_libKotlinCoroutineContextElement> _Nullable)getKey:(id<Drapi_libKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<Drapi_libKotlinCoroutineContext>)minusKeyKey:(id<Drapi_libKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<Drapi_libKotlinCoroutineContext>)plusContext:(id<Drapi_libKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end;

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol Drapi_libKotlinCoroutineContextElement <Drapi_libKotlinCoroutineContext>
@required
@property (readonly) id<Drapi_libKotlinCoroutineContextKey> key;
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeJob")))
@protocol Drapi_libKotlinx_coroutines_core_nativeJob <Drapi_libKotlinCoroutineContextElement>
@required
- (id<Drapi_libKotlinx_coroutines_core_nativeChildHandle>)attachChildChild:(id<Drapi_libKotlinx_coroutines_core_nativeChildJob>)child __attribute__((swift_name("attachChild(child:)")));
- (void)cancel __attribute__((swift_name("cancel()")));
- (BOOL)cancelCause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("cancel(cause:)")));
- (BOOL)cancel0 __attribute__((swift_name("cancel0()")));
- (Drapi_libKotlinx_coroutines_core_nativeCancellationException *)getCancellationException __attribute__((swift_name("getCancellationException()")));
- (id<Drapi_libKotlinx_coroutines_core_nativeDisposableHandle>)invokeOnCompletionOnCancelling:(BOOL)onCancelling invokeImmediately:(BOOL)invokeImmediately handler:(Drapi_libKotlinUnit *(^)(Drapi_libKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(onCancelling:invokeImmediately:handler:)")));
- (id<Drapi_libKotlinx_coroutines_core_nativeDisposableHandle>)invokeOnCompletionHandler:(Drapi_libKotlinUnit *(^)(Drapi_libKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(handler:)")));
- (id<Drapi_libKotlinx_coroutines_core_nativeJob>)plusOther:(id<Drapi_libKotlinx_coroutines_core_nativeJob>)other __attribute__((swift_name("plus(other:)")));
- (BOOL)start __attribute__((swift_name("start()")));
@property (readonly) id<Drapi_libKotlinSequence> children;
@property (readonly) BOOL isActive;
@property (readonly) BOOL isCancelled;
@property (readonly) BOOL isCompleted;
@property (readonly) id<Drapi_libKotlinx_coroutines_core_nativeSelectClause0> onJoin;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinUnit")))
@interface Drapi_libKotlinUnit : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)unit __attribute__((swift_name("init()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeCompositeEncoder")))
@protocol Drapi_libKotlinx_serialization_runtime_nativeCompositeEncoder
@required
- (void)encodeBooleanElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(desc:index:value:)")));
- (void)encodeByteElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(desc:index:value:)")));
- (void)encodeCharElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(desc:index:value:)")));
- (void)encodeDoubleElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(desc:index:value:)")));
- (void)encodeFloatElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(desc:index:value:)")));
- (void)encodeIntElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(desc:index:value:)")));
- (void)encodeLongElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(desc:index:value:)")));
- (void)encodeNonSerializableElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(id)value __attribute__((swift_name("encodeNonSerializableElement(desc:index:value:)")));
- (void)encodeNullableSerializableElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index saver:(id<Drapi_libKotlinx_serialization_runtime_nativeSerializationStrategy>)saver value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(desc:index:saver:value:)")));
- (void)encodeSerializableElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index saver:(id<Drapi_libKotlinx_serialization_runtime_nativeSerializationStrategy>)saver value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(desc:index:saver:value:)")));
- (void)encodeShortElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(desc:index:value:)")));
- (void)encodeStringElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(desc:index:value:)")));
- (void)encodeUnitElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("encodeUnitElement(desc:index:)")));
- (void)endStructureDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc __attribute__((swift_name("endStructure(desc:)")));
- (BOOL)shouldEncodeElementDefaultDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(desc:index:)")));
@property (readonly) id<Drapi_libKotlinx_serialization_runtime_nativeSerialContext> context;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeSerialClassDescImpl")))
@interface Drapi_libKotlinx_serialization_runtime_nativeSerialClassDescImpl : KotlinBase <Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>
- (instancetype)initWithName:(NSString *)name generatedSerializer:(id<Drapi_libKotlinx_serialization_runtime_nativeGeneratedSerializer> _Nullable)generatedSerializer __attribute__((swift_name("init(name:generatedSerializer:)"))) __attribute__((objc_designated_initializer));
- (void)addElementName:(NSString *)name isOptional:(BOOL)isOptional __attribute__((swift_name("addElement(name:isOptional:)")));
- (void)pushAnnotationA:(id<Drapi_libKotlinAnnotation>)a __attribute__((swift_name("pushAnnotation(a:)")));
- (void)pushClassAnnotationA:(id<Drapi_libKotlinAnnotation>)a __attribute__((swift_name("pushClassAnnotation(a:)")));
- (void)pushDescriptorDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc __attribute__((swift_name("pushDescriptor(desc:)")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeEnumDescriptor")))
@interface Drapi_libKotlinx_serialization_runtime_nativeEnumDescriptor : Drapi_libKotlinx_serialization_runtime_nativeSerialClassDescImpl
- (instancetype)initWithName:(NSString *)name choices:(Drapi_libKotlinArray *)choices __attribute__((swift_name("init(name:choices:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithName:(NSString *)name generatedSerializer:(id<Drapi_libKotlinx_serialization_runtime_nativeGeneratedSerializer> _Nullable)generatedSerializer __attribute__((swift_name("init(name:generatedSerializer:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeSerialContext")))
@protocol Drapi_libKotlinx_serialization_runtime_nativeSerialContext
@required
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer> _Nullable)getKclass:(id<Drapi_libKotlinKClass>)kclass __attribute__((swift_name("get(kclass:)")));
- (id<Drapi_libKotlinx_serialization_runtime_nativeKSerializer> _Nullable)getByValueValue:(id)value __attribute__((swift_name("getByValue(value:)")));
@end;

__attribute__((swift_name("KotlinAnnotation")))
@protocol Drapi_libKotlinAnnotation
@required
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeSerialKind")))
@interface Drapi_libKotlinx_serialization_runtime_nativeSerialKind : KotlinBase
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeCompositeDecoder")))
@protocol Drapi_libKotlinx_serialization_runtime_nativeCompositeDecoder
@required
- (BOOL)decodeBooleanElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(desc:index:)")));
- (int8_t)decodeByteElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeByteElement(desc:index:)")));
- (unichar)decodeCharElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeCharElement(desc:index:)")));
- (int32_t)decodeCollectionSizeDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc __attribute__((swift_name("decodeCollectionSize(desc:)")));
- (double)decodeDoubleElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(desc:index:)")));
- (int32_t)decodeElementIndexDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc __attribute__((swift_name("decodeElementIndex(desc:)")));
- (float)decodeFloatElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeFloatElement(desc:index:)")));
- (int32_t)decodeIntElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeIntElement(desc:index:)")));
- (int64_t)decodeLongElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeLongElement(desc:index:)")));
- (id _Nullable)decodeNullableSerializableElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index loader:(id<Drapi_libKotlinx_serialization_runtime_nativeDeserializationStrategy>)loader __attribute__((swift_name("decodeNullableSerializableElement(desc:index:loader:)")));
- (id _Nullable)decodeSerializableElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index loader:(id<Drapi_libKotlinx_serialization_runtime_nativeDeserializationStrategy>)loader __attribute__((swift_name("decodeSerializableElement(desc:index:loader:)")));
- (int16_t)decodeShortElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeShortElement(desc:index:)")));
- (NSString *)decodeStringElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeStringElement(desc:index:)")));
- (void)decodeUnitElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeUnitElement(desc:index:)")));
- (void)endStructureDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc __attribute__((swift_name("endStructure(desc:)")));
- (id _Nullable)updateNullableSerializableElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index loader:(id<Drapi_libKotlinx_serialization_runtime_nativeDeserializationStrategy>)loader old:(id _Nullable)old __attribute__((swift_name("updateNullableSerializableElement(desc:index:loader:old:)")));
- (id _Nullable)updateSerializableElementDesc:(id<Drapi_libKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index loader:(id<Drapi_libKotlinx_serialization_runtime_nativeDeserializationStrategy>)loader old:(id _Nullable)old __attribute__((swift_name("updateSerializableElement(desc:index:loader:old:)")));
@property (readonly) id<Drapi_libKotlinx_serialization_runtime_nativeSerialContext> context;
@property (readonly) Drapi_libKotlinx_serialization_runtime_nativeUpdateMode *updateMode;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface Drapi_libKotlinNothing : KotlinBase
@end;

__attribute__((swift_name("KotlinComparable")))
@protocol Drapi_libKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end;

__attribute__((swift_name("KotlinEnum")))
@interface Drapi_libKotlinEnum : KotlinBase <Drapi_libKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
- (int32_t)compareToOther:(Drapi_libKotlinEnum *)other __attribute__((swift_name("compareTo(other:)")));
@property (readonly) NSString *name;
@property (readonly) int32_t ordinal;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_runtime_nativeUpdateMode")))
@interface Drapi_libKotlinx_serialization_runtime_nativeUpdateMode : Drapi_libKotlinEnum
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
@property (class, readonly) Drapi_libKotlinx_serialization_runtime_nativeUpdateMode *banned;
@property (class, readonly) Drapi_libKotlinx_serialization_runtime_nativeUpdateMode *overwrite;
@property (class, readonly) Drapi_libKotlinx_serialization_runtime_nativeUpdateMode *update;
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (int32_t)compareToOther:(Drapi_libKotlinx_serialization_runtime_nativeUpdateMode *)other __attribute__((swift_name("compareTo(other:)")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol Drapi_libKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((swift_name("Ktor_client_core_iosHttpClientEngine")))
@protocol Drapi_libKtor_client_core_iosHttpClientEngine <Drapi_libKotlinx_coroutines_core_nativeCoroutineScope, Drapi_libKotlinx_io_nativeCloseable>
@required
@property (readonly) Drapi_libKtor_client_core_iosHttpClientEngineConfig *config;
@property (readonly) Drapi_libKotlinx_coroutines_core_nativeCoroutineDispatcher *dispatcher;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_core_iosHttpClientConfig")))
@interface Drapi_libKtor_client_core_iosHttpClientConfig : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (Drapi_libKtor_client_core_iosHttpClientConfig *)clone __attribute__((swift_name("clone()")));
- (void)engineBlock:(Drapi_libKotlinUnit *(^)(Drapi_libKtor_client_core_iosHttpClientEngineConfig *))block __attribute__((swift_name("engine(block:)")));
- (void)installClient:(Drapi_libKtor_client_core_iosHttpClient *)client __attribute__((swift_name("install(client:)")));
- (void)installFeature:(id<Drapi_libKtor_client_core_iosHttpClientFeature>)feature configure:(Drapi_libKotlinUnit *(^)(id))configure __attribute__((swift_name("install(feature:configure:)")));
- (void)installKey:(NSString *)key block:(Drapi_libKotlinUnit *(^)(Drapi_libKtor_client_core_iosHttpClient *))block __attribute__((swift_name("install(key:block:)")));
- (void)plusAssignOther:(Drapi_libKtor_client_core_iosHttpClientConfig *)other __attribute__((swift_name("plusAssign(other:)")));
@property BOOL expectSuccess;
@property BOOL followRedirects;
@property BOOL useDefaultTransformers;
@end;

__attribute__((swift_name("Ktor_utils_iosAttributes")))
@protocol Drapi_libKtor_utils_iosAttributes
@required
- (id)computeIfAbsentKey:(Drapi_libKtor_utils_iosAttributeKey *)key block:(id (^)(void))block __attribute__((swift_name("computeIfAbsent(key:block:)")));
- (BOOL)containsKey:(Drapi_libKtor_utils_iosAttributeKey *)key __attribute__((swift_name("contains(key:)")));
- (id)getKey_:(Drapi_libKtor_utils_iosAttributeKey *)key __attribute__((swift_name("get(key_:)")));
- (id _Nullable)getOrNullKey:(Drapi_libKtor_utils_iosAttributeKey *)key __attribute__((swift_name("getOrNull(key:)")));
- (void)putKey:(Drapi_libKtor_utils_iosAttributeKey *)key value:(id)value __attribute__((swift_name("put(key:value:)")));
- (void)removeKey:(Drapi_libKtor_utils_iosAttributeKey *)key __attribute__((swift_name("remove(key:)")));
- (id)takeKey:(Drapi_libKtor_utils_iosAttributeKey *)key __attribute__((swift_name("take(key:)")));
- (id _Nullable)takeOrNullKey:(Drapi_libKtor_utils_iosAttributeKey *)key __attribute__((swift_name("takeOrNull(key:)")));
@property (readonly) NSArray<Drapi_libKtor_utils_iosAttributeKey *> *allKeys;
@end;

__attribute__((swift_name("KotlinAbstractCoroutineContextElement")))
@interface Drapi_libKotlinAbstractCoroutineContextElement : KotlinBase <Drapi_libKotlinCoroutineContextElement>
- (instancetype)initWithKey:(id<Drapi_libKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinContinuationInterceptor")))
@protocol Drapi_libKotlinContinuationInterceptor <Drapi_libKotlinCoroutineContextElement>
@required
- (id<Drapi_libKotlinContinuation>)interceptContinuationContinuation:(id<Drapi_libKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (void)releaseInterceptedContinuationContinuation:(id<Drapi_libKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeCoroutineDispatcher")))
@interface Drapi_libKotlinx_coroutines_core_nativeCoroutineDispatcher : Drapi_libKotlinAbstractCoroutineContextElement <Drapi_libKotlinContinuationInterceptor>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithKey:(id<Drapi_libKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)dispatchContext:(id<Drapi_libKotlinCoroutineContext>)context block:(id<Drapi_libKotlinx_coroutines_core_nativeRunnable>)block __attribute__((swift_name("dispatch(context:block:)")));
- (void)dispatchYieldContext:(id<Drapi_libKotlinCoroutineContext>)context block:(id<Drapi_libKotlinx_coroutines_core_nativeRunnable>)block __attribute__((swift_name("dispatchYield(context:block:)")));
- (BOOL)isDispatchNeededContext:(id<Drapi_libKotlinCoroutineContext>)context __attribute__((swift_name("isDispatchNeeded(context:)")));
- (Drapi_libKotlinx_coroutines_core_nativeCoroutineDispatcher *)plusOther_:(Drapi_libKotlinx_coroutines_core_nativeCoroutineDispatcher *)other __attribute__((swift_name("plus(other_:)")));
@end;

__attribute__((swift_name("Ktor_client_core_iosHttpClientEngineConfig")))
@interface Drapi_libKtor_client_core_iosHttpClientEngineConfig : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property Drapi_libKotlinx_coroutines_core_nativeCoroutineDispatcher * _Nullable dispatcher;
@property BOOL pipelining;
@property (readonly) Drapi_libKtor_client_core_iosHttpResponseConfig *response;
@property int32_t threadsCount;
@end;

__attribute__((swift_name("Ktor_utils_iosPipeline")))
@interface Drapi_libKtor_utils_iosPipeline : KotlinBase
- (instancetype)initWithPhase:(Drapi_libKtor_utils_iosPipelinePhase *)phase interceptors:(NSArray<id<Drapi_libKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhases:(Drapi_libKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer));
- (void)addPhasePhase:(Drapi_libKtor_utils_iosPipelinePhase *)phase __attribute__((swift_name("addPhase(phase:)")));
- (void)afterIntercepted __attribute__((swift_name("afterIntercepted()")));
- (void)insertPhaseAfterReference:(Drapi_libKtor_utils_iosPipelinePhase *)reference phase:(Drapi_libKtor_utils_iosPipelinePhase *)phase __attribute__((swift_name("insertPhaseAfter(reference:phase:)")));
- (void)insertPhaseBeforeReference:(Drapi_libKtor_utils_iosPipelinePhase *)reference phase:(Drapi_libKtor_utils_iosPipelinePhase *)phase __attribute__((swift_name("insertPhaseBefore(reference:phase:)")));
- (void)interceptPhase:(Drapi_libKtor_utils_iosPipelinePhase *)phase block:(id<Drapi_libKotlinSuspendFunction2>)block __attribute__((swift_name("intercept(phase:block:)")));
- (void)mergeFrom:(Drapi_libKtor_utils_iosPipeline *)from __attribute__((swift_name("merge(from:)")));
@property (readonly) id<Drapi_libKtor_utils_iosAttributes> attributes;
@property (readonly) BOOL isEmpty;
@property (readonly) NSArray<Drapi_libKtor_utils_iosPipelinePhase *> *items;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_core_iosHttpReceivePipeline")))
@interface Drapi_libKtor_client_core_iosHttpReceivePipeline : Drapi_libKtor_utils_iosPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(Drapi_libKtor_utils_iosPipelinePhase *)phase interceptors:(NSArray<id<Drapi_libKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(Drapi_libKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_core_iosHttpRequestPipeline")))
@interface Drapi_libKtor_client_core_iosHttpRequestPipeline : Drapi_libKtor_utils_iosPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(Drapi_libKtor_utils_iosPipelinePhase *)phase interceptors:(NSArray<id<Drapi_libKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(Drapi_libKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_core_iosHttpResponsePipeline")))
@interface Drapi_libKtor_client_core_iosHttpResponsePipeline : Drapi_libKtor_utils_iosPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(Drapi_libKtor_utils_iosPipelinePhase *)phase interceptors:(NSArray<id<Drapi_libKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(Drapi_libKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_core_iosHttpSendPipeline")))
@interface Drapi_libKtor_client_core_iosHttpSendPipeline : Drapi_libKtor_utils_iosPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(Drapi_libKtor_utils_iosPipelinePhase *)phase interceptors:(NSArray<id<Drapi_libKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(Drapi_libKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol Drapi_libKotlinCoroutineContextKey
@required
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeDisposableHandle")))
@protocol Drapi_libKotlinx_coroutines_core_nativeDisposableHandle
@required
- (void)dispose __attribute__((swift_name("dispose()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeChildHandle")))
@protocol Drapi_libKotlinx_coroutines_core_nativeChildHandle <Drapi_libKotlinx_coroutines_core_nativeDisposableHandle>
@required
- (BOOL)childCancelledCause:(Drapi_libKotlinThrowable *)cause __attribute__((swift_name("childCancelled(cause:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeChildJob")))
@protocol Drapi_libKotlinx_coroutines_core_nativeChildJob <Drapi_libKotlinx_coroutines_core_nativeJob>
@required
- (void)parentCancelledParentJob:(id<Drapi_libKotlinx_coroutines_core_nativeParentJob>)parentJob __attribute__((swift_name("parentCancelled(parentJob:)")));
@end;

__attribute__((swift_name("KotlinRuntimeException")))
@interface Drapi_libKotlinRuntimeException : Drapi_libKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinIllegalStateException")))
@interface Drapi_libKotlinIllegalStateException : Drapi_libKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeCancellationException")))
@interface Drapi_libKotlinx_coroutines_core_nativeCancellationException : Drapi_libKotlinIllegalStateException
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithCause:(Drapi_libKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinSequence")))
@protocol Drapi_libKotlinSequence
@required
- (id<Drapi_libKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeSelectClause0")))
@protocol Drapi_libKotlinx_coroutines_core_nativeSelectClause0
@required
- (void)registerSelectClause0Select:(id<Drapi_libKotlinx_coroutines_core_nativeSelectInstance>)select block:(id<Drapi_libKotlinSuspendFunction0>)block __attribute__((swift_name("registerSelectClause0(select:block:)")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeGeneratedSerializer")))
@protocol Drapi_libKotlinx_serialization_runtime_nativeGeneratedSerializer <Drapi_libKotlinx_serialization_runtime_nativeKSerializer>
@required
- (Drapi_libKotlinArray *)childSerializers __attribute__((swift_name("childSerializers()")));
@end;

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol Drapi_libKotlinKDeclarationContainer
@required
@end;

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol Drapi_libKotlinKAnnotatedElement
@required
@end;

__attribute__((swift_name("KotlinKClassifier")))
@protocol Drapi_libKotlinKClassifier
@required
@end;

__attribute__((swift_name("KotlinKClass")))
@protocol Drapi_libKotlinKClass <Drapi_libKotlinKDeclarationContainer, Drapi_libKotlinKAnnotatedElement, Drapi_libKotlinKClassifier>
@required
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName;
@property (readonly) NSString * _Nullable simpleName;
@end;

__attribute__((swift_name("Ktor_client_core_iosHttpClientFeature")))
@protocol Drapi_libKtor_client_core_iosHttpClientFeature
@required
- (void)installFeature:(id)feature scope:(Drapi_libKtor_client_core_iosHttpClient *)scope __attribute__((swift_name("install(feature:scope:)")));
- (id)prepareBlock:(Drapi_libKotlinUnit *(^)(id))block __attribute__((swift_name("prepare(block:)")));
@property (readonly) Drapi_libKtor_utils_iosAttributeKey *key;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utils_iosAttributeKey")))
@interface Drapi_libKtor_utils_iosAttributeKey : KotlinBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
@property (readonly) NSString *name;
@end;

__attribute__((swift_name("KotlinContinuation")))
@protocol Drapi_libKotlinContinuation
@required
- (void)resumeWithResult:(id _Nullable)result __attribute__((swift_name("resumeWith(result:)")));
@property (readonly) id<Drapi_libKotlinCoroutineContext> context;
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeRunnable")))
@protocol Drapi_libKotlinx_coroutines_core_nativeRunnable
@required
- (void)run __attribute__((swift_name("run()")));
@end;

__attribute__((swift_name("Ktor_client_core_iosHttpResponseConfig")))
@interface Drapi_libKtor_client_core_iosHttpResponseConfig : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property Drapi_libKotlinx_io_nativeCharset *defaultCharset;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utils_iosPipelinePhase")))
@interface Drapi_libKtor_utils_iosPipelinePhase : KotlinBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
@property (readonly) NSString *name;
@end;

__attribute__((swift_name("KotlinSuspendFunction")))
@protocol Drapi_libKotlinSuspendFunction
@required
@end;

__attribute__((swift_name("KotlinSuspendFunction2")))
@protocol Drapi_libKotlinSuspendFunction2 <Drapi_libKotlinSuspendFunction>
@required
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeParentJob")))
@protocol Drapi_libKotlinx_coroutines_core_nativeParentJob <Drapi_libKotlinx_coroutines_core_nativeJob>
@required
- (Drapi_libKotlinThrowable *)getChildJobCancellationCause __attribute__((swift_name("getChildJobCancellationCause()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeSelectInstance")))
@protocol Drapi_libKotlinx_coroutines_core_nativeSelectInstance
@required
- (void)disposeOnSelectHandle:(id<Drapi_libKotlinx_coroutines_core_nativeDisposableHandle>)handle __attribute__((swift_name("disposeOnSelect(handle:)")));
- (id _Nullable)performAtomicIfNotSelectedDesc:(Drapi_libKotlinx_coroutines_core_nativeAtomicDesc *)desc __attribute__((swift_name("performAtomicIfNotSelected(desc:)")));
- (id _Nullable)performAtomicTrySelectDesc:(Drapi_libKotlinx_coroutines_core_nativeAtomicDesc *)desc __attribute__((swift_name("performAtomicTrySelect(desc:)")));
- (void)resumeSelectCancellableWithExceptionException:(Drapi_libKotlinThrowable *)exception __attribute__((swift_name("resumeSelectCancellableWithException(exception:)")));
- (BOOL)trySelectIdempotent:(id _Nullable)idempotent __attribute__((swift_name("trySelect(idempotent:)")));
@property (readonly) id<Drapi_libKotlinContinuation> completion;
@property (readonly) BOOL isSelected;
@end;

__attribute__((swift_name("KotlinSuspendFunction0")))
@protocol Drapi_libKotlinSuspendFunction0 <Drapi_libKotlinSuspendFunction>
@required
@end;

__attribute__((swift_name("Kotlinx_io_nativeCharset")))
@interface Drapi_libKotlinx_io_nativeCharset : KotlinBase
- (instancetype)initWith_name:(NSString *)_name __attribute__((swift_name("init(_name:)"))) __attribute__((objc_designated_initializer));
- (Drapi_libKotlinx_io_nativeCharsetDecoder *)doNewDecoder __attribute__((swift_name("doNewDecoder()")));
- (Drapi_libKotlinx_io_nativeCharsetEncoder *)doNewEncoder __attribute__((swift_name("doNewEncoder()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeAtomicDesc")))
@interface Drapi_libKotlinx_coroutines_core_nativeAtomicDesc : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeOp:(Drapi_libKotlinx_coroutines_core_nativeAtomicOp *)op failure:(id _Nullable)failure __attribute__((swift_name("complete(op:failure:)")));
- (id _Nullable)prepareOp:(Drapi_libKotlinx_coroutines_core_nativeAtomicOp *)op __attribute__((swift_name("prepare(op:)")));
@end;

__attribute__((swift_name("Kotlinx_io_nativeCharsetDecoder")))
@interface Drapi_libKotlinx_io_nativeCharsetDecoder : KotlinBase
- (instancetype)initWith_charset:(Drapi_libKotlinx_io_nativeCharset *)_charset __attribute__((swift_name("init(_charset:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_io_nativeCharsetEncoder")))
@interface Drapi_libKotlinx_io_nativeCharsetEncoder : KotlinBase
- (instancetype)initWith_charset:(Drapi_libKotlinx_io_nativeCharset *)_charset __attribute__((swift_name("init(_charset:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeOpDescriptor")))
@interface Drapi_libKotlinx_coroutines_core_nativeOpDescriptor : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeAtomicOp")))
@interface Drapi_libKotlinx_coroutines_core_nativeAtomicOp : Drapi_libKotlinx_coroutines_core_nativeOpDescriptor
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeAffected:(id _Nullable)affected failure:(id _Nullable)failure __attribute__((swift_name("complete(affected:failure:)")));
- (id _Nullable)prepareAffected:(id _Nullable)affected __attribute__((swift_name("prepare(affected:)")));
- (BOOL)tryDecideDecision:(id _Nullable)decision __attribute__((swift_name("tryDecide(decision:)")));
@property (readonly) BOOL isDecided;
@end;

NS_ASSUME_NONNULL_END
