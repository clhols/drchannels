#import <Foundation/Foundation.h>

@class DrapiDate, DrapiDateSerializer, DrapiSearchResult, DrapiProgramCard, DrapiMuPaging, DrapiSearchResultCompanion, DrapiSearchResult$serializer, DrapiKotlinArray, DrapiMuPagingCompanion, DrapiMuPaging$serializer, DrapiSchedule, DrapiMuScheduleBroadcast, DrapiScheduleCompanion, DrapiSchedule$serializer, DrapiChannel, DrapiMuStreamingServer, DrapiChannelCompanion, DrapiChannel$serializer, DrapiMuStreamQuality, DrapiMuStreamingServerCompanion, DrapiMuStreamingServer$serializer, DrapiMuStream, DrapiMuStreamQualityCompanion, DrapiMuStreamQuality$serializer, DrapiMuStreamCompanion, DrapiMuStream$serializer, DrapiMuNowNext, DrapiMuNowNextCompanion, DrapiMuNowNext$serializer, DrapiMuScheduleBroadcastCompanion, DrapiMuScheduleBroadcast$serializer, DrapiPrimaryAsset, DrapiInfo, DrapiProgramCardCompanion, DrapiProgramCard$serializer, DrapiInfoCompanion, DrapiInfo$serializer, DrapiPrimaryAssetCompanion, DrapiPrimaryAsset$serializer, DrapiManifest, DrapiLink, DrapiSubtitle, DrapiManifestCompanion, DrapiManifest$serializer, DrapiLinkCompanion, DrapiLink$serializer, DrapiSubtitleCompanion, DrapiSubtitle$serializer, DrapiMostViewed, DrapiMostViewedCompanion, DrapiMostViewed$serializer, DrapiPrograms, DrapiProgramsCompanion, DrapiPrograms$serializer, DrapiPage, DrapiPageCompanion, DrapiPage$serializer, DrapiGenre, DrapiGenreDrama, DrapiGenreDokumentar, DrapiGenreLivsstil, DrapiGenreKultur, DrapiGenreNaturViden, DrapiGenreNyhederAktualitet, DrapiGenreSport, DrapiGenreUnderholdning, DrapiGenreCompanion, DrapiDrMuException, DrapiKotlinException, DrapiKotlinThrowable, DrapiDrMuRepository, DrapiHttpClientFactory, DrapiKtor_client_coreHttpClient, DrapiDrMuRepositoryCallback, DrapiKotlinUnit, DrapiKotlinx_serialization_runtime_nativeEnumDescriptor, DrapiKotlinx_serialization_runtime_nativeSerialKind, DrapiKotlinNothing, DrapiKotlinx_serialization_runtime_nativeUpdateMode, DrapiKtor_client_coreHttpClientConfig, DrapiKotlinx_coroutines_core_nativeCoroutineDispatcher, DrapiKtor_client_coreHttpClientEngineConfig, DrapiKtor_client_coreHttpReceivePipeline, DrapiKtor_client_coreHttpRequestPipeline, DrapiKtor_client_coreHttpResponsePipeline, DrapiKtor_client_coreHttpSendPipeline, DrapiKotlinx_coroutines_core_nativeCancellationException, DrapiKotlinx_serialization_runtime_nativeSerialClassDescImpl, DrapiKotlinEnum, DrapiKtor_utilsAttributeKey, DrapiKotlinAbstractCoroutineContextElement, DrapiKtor_client_coreHttpResponseConfig, DrapiKtor_utilsPipeline, DrapiKtor_utilsPipelinePhase, DrapiKotlinIllegalStateException, DrapiKotlinRuntimeException, DrapiKotlinx_ioCharset, DrapiKotlinx_coroutines_core_nativeAtomicDesc, DrapiKotlinx_ioCharsetDecoder, DrapiKotlinx_ioCharsetEncoder, DrapiKotlinx_coroutines_core_nativeAtomicOp, DrapiKotlinx_coroutines_core_nativeOpDescriptor;

@protocol DrapiKotlinx_serialization_runtime_nativeKSerializer, DrapiKotlinx_serialization_runtime_nativeSerializationStrategy, DrapiKotlinx_serialization_runtime_nativeEncoder, DrapiKotlinx_serialization_runtime_nativeSerialDescriptor, DrapiKotlinx_serialization_runtime_nativeDeserializationStrategy, DrapiKotlinx_serialization_runtime_nativeDecoder, DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer, DrapiKotlinx_coroutines_core_nativeCoroutineScope, DrapiKotlinCoroutineContext, DrapiKotlinx_coroutines_core_nativeJob, DrapiKotlinx_serialization_runtime_nativeCompositeEncoder, DrapiKotlinx_serialization_runtime_nativeSerialContext, DrapiKotlinAnnotation, DrapiKotlinx_serialization_runtime_nativeCompositeDecoder, DrapiKotlinIterator, DrapiKotlinx_ioCloseable, DrapiKtor_client_coreHttpClientEngine, DrapiKtor_utilsAttributes, DrapiKotlinCoroutineContextElement, DrapiKotlinCoroutineContextKey, DrapiKotlinx_coroutines_core_nativeChildHandle, DrapiKotlinx_coroutines_core_nativeChildJob, DrapiKotlinx_coroutines_core_nativeDisposableHandle, DrapiKotlinSequence, DrapiKotlinx_coroutines_core_nativeSelectClause0, DrapiKotlinKClass, DrapiKotlinComparable, DrapiKtor_client_coreHttpClientFeature, DrapiKotlinContinuationInterceptor, DrapiKotlinContinuation, DrapiKotlinx_coroutines_core_nativeRunnable, DrapiKotlinSuspendFunction2, DrapiKotlinx_coroutines_core_nativeParentJob, DrapiKotlinx_coroutines_core_nativeSelectInstance, DrapiKotlinSuspendFunction0, DrapiKotlinKDeclarationContainer, DrapiKotlinKAnnotatedElement, DrapiKotlinKClassifier, DrapiKotlinSuspendFunction;

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
@property int64_t time;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeSerializationStrategy")))
@protocol DrapiKotlinx_serialization_runtime_nativeSerializationStrategy
@required
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(id _Nullable)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor> descriptor;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeDeserializationStrategy")))
@protocol DrapiKotlinx_serialization_runtime_nativeDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (id _Nullable)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(id _Nullable)old __attribute__((swift_name("patch(decoder:old:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor> descriptor;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeKSerializer")))
@protocol DrapiKotlinx_serialization_runtime_nativeKSerializer <DrapiKotlinx_serialization_runtime_nativeSerializationStrategy, DrapiKotlinx_serialization_runtime_nativeDeserializationStrategy>
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DateSerializer")))
@interface DrapiDateSerializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)dateSerializer __attribute__((swift_name("init()")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiDate *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
- (DrapiDate *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiDate *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiDate *)old __attribute__((swift_name("patch(decoder:old:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchResult")))
@interface DrapiSearchResult : KotlinBase
- (instancetype)initWithTitle:(NSString *)Title Subtitle:(NSString *)Subtitle Description:(NSString *)Description IsRepremiere:(BOOL)IsRepremiere BundleType:(NSString *)BundleType ThemeType:(NSString *)ThemeType Slug:(NSString *)Slug Items:(NSArray<DrapiProgramCard *> *)Items Paging:(DrapiMuPaging *)Paging TotalSize:(int32_t)TotalSize BackgroundImageUri:(NSString *)BackgroundImageUri SiteUrl:(NSString *)SiteUrl __attribute__((swift_name("init(Title:Subtitle:Description:IsRepremiere:BundleType:ThemeType:Slug:Items:Paging:TotalSize:BackgroundImageUri:SiteUrl:)"))) __attribute__((objc_designated_initializer));
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
@property (readonly) NSString *Title;
@property (readonly) NSString *Subtitle;
@property (readonly) NSString *Description;
@property (readonly) BOOL IsRepremiere;
@property (readonly) NSString *BundleType;
@property (readonly) NSString *ThemeType;
@property (readonly) NSString *Slug;
@property (readonly) NSArray<DrapiProgramCard *> *Items;
@property (readonly) DrapiMuPaging *Paging;
@property (readonly) int32_t TotalSize;
@property (readonly) NSString *BackgroundImageUri;
@property (readonly) NSString *SiteUrl;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchResult.Companion")))
@interface DrapiSearchResultCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeGeneratedSerializer")))
@protocol DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer <DrapiKotlinx_serialization_runtime_nativeKSerializer>
@required
- (DrapiKotlinArray *)childSerializers __attribute__((swift_name("childSerializers()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchResult.$serializer")))
@interface DrapiSearchResult$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiSearchResult *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiSearchResult *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiSearchResult *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiSearchResult *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuPaging")))
@interface DrapiMuPaging : KotlinBase
- (instancetype)initWithTitle:(NSString *)Title Source:(NSString *)Source Next:(NSString *)Next Previous:(NSString *)Previous TotalSize:(int32_t)TotalSize __attribute__((swift_name("init(Title:Source:Next:Previous:TotalSize:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (int32_t)component5 __attribute__((swift_name("component5()")));
- (DrapiMuPaging *)doCopyTitle:(NSString *)Title Source:(NSString *)Source Next:(NSString *)Next Previous:(NSString *)Previous TotalSize:(int32_t)TotalSize __attribute__((swift_name("doCopy(Title:Source:Next:Previous:TotalSize:)")));
@property (readonly) NSString *Title;
@property (readonly) NSString *Source;
@property (readonly) NSString *Next;
@property (readonly) NSString *Previous;
@property (readonly) int32_t TotalSize;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuPaging.Companion")))
@interface DrapiMuPagingCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuPaging.$serializer")))
@interface DrapiMuPaging$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiMuPaging *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuPaging *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiMuPaging *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiMuPaging *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Schedule")))
@interface DrapiSchedule : KotlinBase
- (instancetype)initWithBroadcasts:(NSArray<DrapiMuScheduleBroadcast *> *)Broadcasts BroadcastDate:(DrapiDate *)BroadcastDate ChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel __attribute__((swift_name("init(Broadcasts:BroadcastDate:ChannelSlug:Channel:)"))) __attribute__((objc_designated_initializer));
- (NSArray<DrapiMuScheduleBroadcast *> *)component1 __attribute__((swift_name("component1()")));
- (DrapiDate *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (DrapiSchedule *)doCopyBroadcasts:(NSArray<DrapiMuScheduleBroadcast *> *)Broadcasts BroadcastDate:(DrapiDate *)BroadcastDate ChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel __attribute__((swift_name("doCopy(Broadcasts:BroadcastDate:ChannelSlug:Channel:)")));
@property (readonly) NSArray<DrapiMuScheduleBroadcast *> *Broadcasts;
@property (readonly) DrapiDate *BroadcastDate;
@property (readonly) NSString *ChannelSlug;
@property (readonly) NSString *Channel;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Schedule.Companion")))
@interface DrapiScheduleCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Schedule.$serializer")))
@interface DrapiSchedule$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiSchedule *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiSchedule *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiSchedule *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiSchedule *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Channel")))
@interface DrapiChannel : KotlinBase
- (instancetype)initWithType:(NSString *)Type StreamingServers:(NSArray<DrapiMuStreamingServer *> *)StreamingServers Url:(NSString *)Url SourceUrl:(NSString *)SourceUrl WebChannel:(BOOL)WebChannel Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title ItemLabel:(NSString *)ItemLabel Subtitle:(NSString *)Subtitle __attribute__((swift_name("init(Type:StreamingServers:Url:SourceUrl:WebChannel:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:ItemLabel:Subtitle:)"))) __attribute__((objc_designated_initializer));
- (DrapiMuStreamingServer * _Nullable)server __attribute__((swift_name("server()")));
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
@property (readonly) NSString *Type;
@property (readonly) NSArray<DrapiMuStreamingServer *> *StreamingServers;
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
@interface DrapiChannelCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Channel.$serializer")))
@interface DrapiChannel$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiChannel *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiChannel *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiChannel *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiChannel *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamingServer")))
@interface DrapiMuStreamingServer : KotlinBase
- (instancetype)initWithServer:(NSString *)Server LinkType:(NSString *)LinkType Qualities:(NSArray<DrapiMuStreamQuality *> *)Qualities DynamicUserQualityChange:(BOOL)DynamicUserQualityChange EncryptedServer:(NSString *)EncryptedServer __attribute__((swift_name("init(Server:LinkType:Qualities:DynamicUserQualityChange:EncryptedServer:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSArray<DrapiMuStreamQuality *> *)component3 __attribute__((swift_name("component3()")));
- (BOOL)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (DrapiMuStreamingServer *)doCopyServer:(NSString *)Server LinkType:(NSString *)LinkType Qualities:(NSArray<DrapiMuStreamQuality *> *)Qualities DynamicUserQualityChange:(BOOL)DynamicUserQualityChange EncryptedServer:(NSString *)EncryptedServer __attribute__((swift_name("doCopy(Server:LinkType:Qualities:DynamicUserQualityChange:EncryptedServer:)")));
@property (readonly) NSString *Server;
@property (readonly) NSString *LinkType;
@property (readonly) NSArray<DrapiMuStreamQuality *> *Qualities;
@property (readonly) BOOL DynamicUserQualityChange;
@property (readonly) NSString *EncryptedServer;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamingServer.Companion")))
@interface DrapiMuStreamingServerCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamingServer.$serializer")))
@interface DrapiMuStreamingServer$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiMuStreamingServer *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuStreamingServer *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiMuStreamingServer *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiMuStreamingServer *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamQuality")))
@interface DrapiMuStreamQuality : KotlinBase
- (instancetype)initWithKbps:(int32_t)Kbps Streams:(NSArray<DrapiMuStream *> *)Streams __attribute__((swift_name("init(Kbps:Streams:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSArray<DrapiMuStream *> *)component2 __attribute__((swift_name("component2()")));
- (DrapiMuStreamQuality *)doCopyKbps:(int32_t)Kbps Streams:(NSArray<DrapiMuStream *> *)Streams __attribute__((swift_name("doCopy(Kbps:Streams:)")));
@property (readonly) int32_t Kbps;
@property (readonly) NSArray<DrapiMuStream *> *Streams;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamQuality.Companion")))
@interface DrapiMuStreamQualityCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStreamQuality.$serializer")))
@interface DrapiMuStreamQuality$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiMuStreamQuality *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuStreamQuality *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiMuStreamQuality *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiMuStreamQuality *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStream")))
@interface DrapiMuStream : KotlinBase
- (instancetype)initWithStream:(NSString *)Stream EncryptedStream:(NSString *)EncryptedStream __attribute__((swift_name("init(Stream:EncryptedStream:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (DrapiMuStream *)doCopyStream:(NSString *)Stream EncryptedStream:(NSString *)EncryptedStream __attribute__((swift_name("doCopy(Stream:EncryptedStream:)")));
@property (readonly) NSString *Stream;
@property (readonly) NSString *EncryptedStream;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStream.Companion")))
@interface DrapiMuStreamCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuStream.$serializer")))
@interface DrapiMuStream$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiMuStream *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuStream *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiMuStream *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiMuStream *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuNowNext")))
@interface DrapiMuNowNext : KotlinBase
- (instancetype)initWithChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel Now:(DrapiMuScheduleBroadcast * _Nullable)Now Next:(NSArray<DrapiMuScheduleBroadcast *> *)Next __attribute__((swift_name("init(ChannelSlug:Channel:Now:Next:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (DrapiMuScheduleBroadcast * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSArray<DrapiMuScheduleBroadcast *> *)component4 __attribute__((swift_name("component4()")));
- (DrapiMuNowNext *)doCopyChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel Now:(DrapiMuScheduleBroadcast * _Nullable)Now Next:(NSArray<DrapiMuScheduleBroadcast *> *)Next __attribute__((swift_name("doCopy(ChannelSlug:Channel:Now:Next:)")));
@property (readonly) NSString *ChannelSlug;
@property (readonly) NSString *Channel;
@property (readonly) DrapiMuScheduleBroadcast * _Nullable Now;
@property (readonly) NSArray<DrapiMuScheduleBroadcast *> *Next;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuNowNext.Companion")))
@interface DrapiMuNowNextCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuNowNext.$serializer")))
@interface DrapiMuNowNext$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiMuNowNext *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuNowNext *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiMuNowNext *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiMuNowNext *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuScheduleBroadcast")))
@interface DrapiMuScheduleBroadcast : KotlinBase
- (instancetype)initWithTitle:(NSString *)Title Description:(NSString *)Description Subtitle:(NSString *)Subtitle StartTime:(DrapiDate *)StartTime EndTime:(DrapiDate *)EndTime ProgramCard:(DrapiProgramCard *)ProgramCard OnlineGenreText:(NSString * _Nullable)OnlineGenreText ProductionNumber:(NSString *)ProductionNumber ProgramCardHasPrimaryAsset:(BOOL)ProgramCardHasPrimaryAsset SeriesHasProgramCardWithPrimaryAsset:(BOOL)SeriesHasProgramCardWithPrimaryAsset AnnouncedStartTime:(DrapiDate *)AnnouncedStartTime AnnouncedEndTime:(DrapiDate *)AnnouncedEndTime ProductionCountry:(NSString *)ProductionCountry ProductionYear:(int32_t)ProductionYear VideoWidescreen:(BOOL)VideoWidescreen SubtitlesTTV:(BOOL)SubtitlesTTV VideoHD:(BOOL)VideoHD WhatsOnUri:(NSString *)WhatsOnUri IsRerun:(BOOL)IsRerun __attribute__((swift_name("init(Title:Description:Subtitle:StartTime:EndTime:ProgramCard:OnlineGenreText:ProductionNumber:ProgramCardHasPrimaryAsset:SeriesHasProgramCardWithPrimaryAsset:AnnouncedStartTime:AnnouncedEndTime:ProductionCountry:ProductionYear:VideoWidescreen:SubtitlesTTV:VideoHD:WhatsOnUri:IsRerun:)"))) __attribute__((objc_designated_initializer));
- (NSString * _Nullable)getPrimaryAssetUri __attribute__((swift_name("getPrimaryAssetUri()")));
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
@property (readonly) NSString *Title;
@property (readonly) NSString *Description;
@property (readonly) NSString *Subtitle;
@property (readonly) DrapiDate *StartTime;
@property (readonly) DrapiDate *EndTime;
@property (readonly) DrapiProgramCard *ProgramCard;
@property (readonly) NSString * _Nullable OnlineGenreText;
@property (readonly) NSString *ProductionNumber;
@property (readonly) BOOL ProgramCardHasPrimaryAsset;
@property (readonly) BOOL SeriesHasProgramCardWithPrimaryAsset;
@property (readonly) DrapiDate *AnnouncedStartTime;
@property (readonly) DrapiDate *AnnouncedEndTime;
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
@interface DrapiMuScheduleBroadcastCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MuScheduleBroadcast.$serializer")))
@interface DrapiMuScheduleBroadcast$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiMuScheduleBroadcast *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMuScheduleBroadcast *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiMuScheduleBroadcast *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiMuScheduleBroadcast *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProgramCard")))
@interface DrapiProgramCard : KotlinBase
- (instancetype)initWithType:(NSString *)Type SeriesTitle:(NSString *)SeriesTitle EpisodeTitle:(NSString *)EpisodeTitle SeriesSlug:(NSString *)SeriesSlug SeriesUrn:(NSString *)SeriesUrn HostName:(NSString *)HostName SeriesHostName:(NSString *)SeriesHostName PrimaryChannel:(NSString *)PrimaryChannel PrimaryChannelSlug:(NSString *)PrimaryChannelSlug SeasonEpisodeNumberingValid:(BOOL)SeasonEpisodeNumberingValid SeasonTitle:(NSString * _Nullable)SeasonTitle SeasonSlug:(NSString * _Nullable)SeasonSlug SeasonUrn:(NSString * _Nullable)SeasonUrn SeasonNumber:(int32_t)SeasonNumber PrePremiere:(BOOL)PrePremiere ExpiresSoon:(BOOL)ExpiresSoon OnlineGenreText:(NSString *)OnlineGenreText PrimaryAsset:(DrapiPrimaryAsset * _Nullable)PrimaryAsset HasPublicPrimaryAsset:(BOOL)HasPublicPrimaryAsset AssetTargetTypes:(NSString *)AssetTargetTypes PrimaryBroadcastStartTime:(DrapiDate * _Nullable)PrimaryBroadcastStartTime SortDateTime:(DrapiDate *)SortDateTime OnDemandInfo:(DrapiInfo * _Nullable)OnDemandInfo Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title Subtitle:(NSString *)Subtitle IsNewSeries:(BOOL)IsNewSeries OriginalTitle:(NSString *)OriginalTitle RectificationStatus:(NSString *)RectificationStatus RectificationAuto:(BOOL)RectificationAuto RectificationText:(NSString *)RectificationText __attribute__((swift_name("init(Type:SeriesTitle:EpisodeTitle:SeriesSlug:SeriesUrn:HostName:SeriesHostName:PrimaryChannel:PrimaryChannelSlug:SeasonEpisodeNumberingValid:SeasonTitle:SeasonSlug:SeasonUrn:SeasonNumber:PrePremiere:ExpiresSoon:OnlineGenreText:PrimaryAsset:HasPublicPrimaryAsset:AssetTargetTypes:PrimaryBroadcastStartTime:SortDateTime:OnDemandInfo:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:Subtitle:IsNewSeries:OriginalTitle:RectificationStatus:RectificationAuto:RectificationText:)"))) __attribute__((objc_designated_initializer));
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
@property (readonly) DrapiPrimaryAsset * _Nullable PrimaryAsset;
@property (readonly) BOOL HasPublicPrimaryAsset;
@property (readonly) NSString *AssetTargetTypes;
@property (readonly) DrapiDate * _Nullable PrimaryBroadcastStartTime;
@property (readonly) DrapiDate *SortDateTime;
@property (readonly) DrapiInfo * _Nullable OnDemandInfo;
@property (readonly) NSString *Slug;
@property (readonly) NSString *Urn;
@property (readonly) NSString *PrimaryImageUri;
@property (readonly) NSString *PresentationUri;
@property (readonly) NSString *PresentationUriAutoplay;
@property (readonly) NSString *Title;
@property (readonly) NSString *Subtitle;
@property (readonly) BOOL IsNewSeries;
@property (readonly) NSString *OriginalTitle;
@property (readonly) NSString *RectificationStatus;
@property (readonly) BOOL RectificationAuto;
@property (readonly) NSString *RectificationText;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProgramCard.Companion")))
@interface DrapiProgramCardCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProgramCard.$serializer")))
@interface DrapiProgramCard$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiProgramCard *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiProgramCard *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiProgramCard *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiProgramCard *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Info")))
@interface DrapiInfo : KotlinBase
- (instancetype)initWithStartPublish:(DrapiDate *)StartPublish EndPublish:(DrapiDate *)EndPublish __attribute__((swift_name("init(StartPublish:EndPublish:)"))) __attribute__((objc_designated_initializer));
- (DrapiDate *)component1 __attribute__((swift_name("component1()")));
- (DrapiDate *)component2 __attribute__((swift_name("component2()")));
- (DrapiInfo *)doCopyStartPublish:(DrapiDate *)StartPublish EndPublish:(DrapiDate *)EndPublish __attribute__((swift_name("doCopy(StartPublish:EndPublish:)")));
@property (readonly) DrapiDate *StartPublish;
@property (readonly) DrapiDate *EndPublish;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Info.Companion")))
@interface DrapiInfoCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Info.$serializer")))
@interface DrapiInfo$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiInfo *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiInfo *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiInfo *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiInfo *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PrimaryAsset")))
@interface DrapiPrimaryAsset : KotlinBase
- (instancetype)initWithKind:(NSString *)Kind Uri:(NSString *)Uri DurationInMilliseconds:(int64_t)DurationInMilliseconds Downloadable:(BOOL)Downloadable RestrictedToDenmark:(BOOL)RestrictedToDenmark StartPublish:(DrapiDate *)StartPublish EndPublish:(DrapiDate *)EndPublish Target:(NSString *)Target Encrypted:(BOOL)Encrypted IsLiveStream:(BOOL)IsLiveStream __attribute__((swift_name("init(Kind:Uri:DurationInMilliseconds:Downloadable:RestrictedToDenmark:StartPublish:EndPublish:Target:Encrypted:IsLiveStream:)"))) __attribute__((objc_designated_initializer));
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
@property (readonly) NSString *Kind;
@property (readonly) NSString *Uri;
@property (readonly) int64_t DurationInMilliseconds;
@property (readonly) BOOL Downloadable;
@property (readonly) BOOL RestrictedToDenmark;
@property (readonly) DrapiDate *StartPublish;
@property (readonly) DrapiDate *EndPublish;
@property (readonly) NSString *Target;
@property (readonly) BOOL Encrypted;
@property (readonly) BOOL IsLiveStream;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PrimaryAsset.Companion")))
@interface DrapiPrimaryAssetCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PrimaryAsset.$serializer")))
@interface DrapiPrimaryAsset$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiPrimaryAsset *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiPrimaryAsset *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiPrimaryAsset *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiPrimaryAsset *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Manifest")))
@interface DrapiManifest : KotlinBase
- (instancetype)initWithLinks:(NSArray<DrapiLink *> *)Links SubtitlesList:(NSArray<DrapiSubtitle *> *)SubtitlesList __attribute__((swift_name("init(Links:SubtitlesList:)"))) __attribute__((objc_designated_initializer));
- (NSString * _Nullable)getUri __attribute__((swift_name("getUri()")));
- (NSArray<DrapiLink *> *)component1 __attribute__((swift_name("component1()")));
- (NSArray<DrapiSubtitle *> *)component2 __attribute__((swift_name("component2()")));
- (DrapiManifest *)doCopyLinks:(NSArray<DrapiLink *> *)Links SubtitlesList:(NSArray<DrapiSubtitle *> *)SubtitlesList __attribute__((swift_name("doCopy(Links:SubtitlesList:)")));
@property (readonly) NSArray<DrapiLink *> *Links;
@property (readonly) NSArray<DrapiSubtitle *> *SubtitlesList;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Manifest.Companion")))
@interface DrapiManifestCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Manifest.$serializer")))
@interface DrapiManifest$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiManifest *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiManifest *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiManifest *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiManifest *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Link")))
@interface DrapiLink : KotlinBase
- (instancetype)initWithHardSubtitlesType:(NSString *)HardSubtitlesType Uri:(NSString *)Uri EncryptedUri:(NSString *)EncryptedUri FileFormat:(NSString *)FileFormat Target:(NSString *)Target Bitrate:(int32_t)Bitrate __attribute__((swift_name("init(HardSubtitlesType:Uri:EncryptedUri:FileFormat:Target:Bitrate:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (int32_t)component6 __attribute__((swift_name("component6()")));
- (DrapiLink *)doCopyHardSubtitlesType:(NSString *)HardSubtitlesType Uri:(NSString *)Uri EncryptedUri:(NSString *)EncryptedUri FileFormat:(NSString *)FileFormat Target:(NSString *)Target Bitrate:(int32_t)Bitrate __attribute__((swift_name("doCopy(HardSubtitlesType:Uri:EncryptedUri:FileFormat:Target:Bitrate:)")));
@property (readonly) NSString *HardSubtitlesType;
@property (readonly) NSString *Uri;
@property (readonly) NSString *EncryptedUri;
@property (readonly) NSString *FileFormat;
@property (readonly) NSString *Target;
@property (readonly) int32_t Bitrate;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Link.Companion")))
@interface DrapiLinkCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Link.$serializer")))
@interface DrapiLink$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiLink *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiLink *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiLink *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiLink *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Subtitle")))
@interface DrapiSubtitle : KotlinBase
- (instancetype)initWithLanguage:(NSString *)Language MimeType:(NSString *)MimeType Type:(NSString *)Type Uri:(NSString *)Uri __attribute__((swift_name("init(Language:MimeType:Type:Uri:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (DrapiSubtitle *)doCopyLanguage:(NSString *)Language MimeType:(NSString *)MimeType Type:(NSString *)Type Uri:(NSString *)Uri __attribute__((swift_name("doCopy(Language:MimeType:Type:Uri:)")));
@property (readonly) NSString *Language;
@property (readonly) NSString *MimeType;
@property (readonly) NSString *Type;
@property (readonly) NSString *Uri;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Subtitle.Companion")))
@interface DrapiSubtitleCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Subtitle.$serializer")))
@interface DrapiSubtitle$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiSubtitle *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiSubtitle *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiSubtitle *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiSubtitle *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MostViewed")))
@interface DrapiMostViewed : KotlinBase
- (instancetype)initWithItems:(NSArray<DrapiProgramCard *> *)Items Paging:(DrapiMuPaging *)Paging TotalSize:(int32_t)TotalSize __attribute__((swift_name("init(Items:Paging:TotalSize:)"))) __attribute__((objc_designated_initializer));
- (NSArray<DrapiProgramCard *> *)component1 __attribute__((swift_name("component1()")));
- (DrapiMuPaging *)component2 __attribute__((swift_name("component2()")));
- (int32_t)component3 __attribute__((swift_name("component3()")));
- (DrapiMostViewed *)doCopyItems:(NSArray<DrapiProgramCard *> *)Items Paging:(DrapiMuPaging *)Paging TotalSize:(int32_t)TotalSize __attribute__((swift_name("doCopy(Items:Paging:TotalSize:)")));
@property (readonly) NSArray<DrapiProgramCard *> *Items;
@property (readonly) DrapiMuPaging *Paging;
@property (readonly) int32_t TotalSize;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MostViewed.Companion")))
@interface DrapiMostViewedCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MostViewed.$serializer")))
@interface DrapiMostViewed$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiMostViewed *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiMostViewed *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiMostViewed *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiMostViewed *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Programs")))
@interface DrapiPrograms : KotlinBase
- (instancetype)initWithItems:(NSArray<DrapiProgramCard *> *)Items Paging:(DrapiMuPaging *)Paging TotalSize:(int32_t)TotalSize __attribute__((swift_name("init(Items:Paging:TotalSize:)"))) __attribute__((objc_designated_initializer));
- (NSArray<DrapiProgramCard *> *)component1 __attribute__((swift_name("component1()")));
- (DrapiMuPaging *)component2 __attribute__((swift_name("component2()")));
- (int32_t)component3 __attribute__((swift_name("component3()")));
- (DrapiPrograms *)doCopyItems:(NSArray<DrapiProgramCard *> *)Items Paging:(DrapiMuPaging *)Paging TotalSize:(int32_t)TotalSize __attribute__((swift_name("doCopy(Items:Paging:TotalSize:)")));
@property (readonly) NSArray<DrapiProgramCard *> *Items;
@property (readonly) DrapiMuPaging *Paging;
@property (readonly) int32_t TotalSize;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Programs.Companion")))
@interface DrapiProgramsCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Programs.$serializer")))
@interface DrapiPrograms$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiPrograms *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiPrograms *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiPrograms *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiPrograms *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Page")))
@interface DrapiPage : KotlinBase
- (instancetype)initWithPrograms:(DrapiPrograms *)Programs __attribute__((swift_name("init(Programs:)"))) __attribute__((objc_designated_initializer));
- (DrapiPrograms *)component1 __attribute__((swift_name("component1()")));
- (DrapiPage *)doCopyPrograms:(DrapiPrograms *)Programs __attribute__((swift_name("doCopy(Programs:)")));
@property (readonly) DrapiPrograms *Programs;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Page.Companion")))
@interface DrapiPageCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Page.$serializer")))
@interface DrapiPage$serializer : KotlinBase <DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)$serializer __attribute__((swift_name("init()")));
- (DrapiPage *)deserializeDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (DrapiPage *)patchDecoder:(id<DrapiKotlinx_serialization_runtime_nativeDecoder>)decoder old:(DrapiPage *)old __attribute__((swift_name("patch(decoder:old:)")));
- (void)serializeEncoder:(id<DrapiKotlinx_serialization_runtime_nativeEncoder>)encoder obj:(DrapiPage *)obj __attribute__((swift_name("serialize(encoder:obj:)")));
@end;

__attribute__((swift_name("Genre")))
@interface DrapiGenre : KotlinBase
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

__attribute__((swift_name("KotlinThrowable")))
@interface DrapiKotlinThrowable : KotlinBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (DrapiKotlinArray *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
@property (readonly) DrapiKotlinThrowable * _Nullable cause;
@property (readonly) NSString * _Nullable message;
@end;

__attribute__((swift_name("KotlinException")))
@interface DrapiKotlinException : DrapiKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrMuException")))
@interface DrapiDrMuException : DrapiKotlinException
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithCause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
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

__attribute__((swift_name("Kotlinx_coroutines_core_nativeCoroutineScope")))
@protocol DrapiKotlinx_coroutines_core_nativeCoroutineScope
@required
@property (readonly) id<DrapiKotlinCoroutineContext> coroutineContext;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrMuRepositoryCallback")))
@interface DrapiDrMuRepositoryCallback : DrapiDrMuRepository <DrapiKotlinx_coroutines_core_nativeCoroutineScope>
- (instancetype)initWithCoroutineContext:(id<DrapiKotlinCoroutineContext>)coroutineContext __attribute__((swift_name("init(coroutineContext:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCacheDir:(NSString * _Nullable)cacheDir sizeBytes:(int64_t)sizeBytes __attribute__((swift_name("init(cacheDir:sizeBytes:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (id<DrapiKotlinx_coroutines_core_nativeJob>)getAllActiveDrTvChannelsCallback:(DrapiKotlinUnit *(^)(NSArray<DrapiChannel *> *))callback __attribute__((swift_name("getAllActiveDrTvChannels(callback:)")));
- (id<DrapiKotlinx_coroutines_core_nativeJob>)getManifestUri:(NSString *)uri callback:(DrapiKotlinUnit *(^)(DrapiManifest *))callback __attribute__((swift_name("getManifest(uri:callback:)")));
- (id<DrapiKotlinx_coroutines_core_nativeJob>)getScheduleId:(NSString *)id date:(NSString *)date callback:(DrapiKotlinUnit *(^)(DrapiSchedule *))callback __attribute__((swift_name("getSchedule(id:date:callback:)")));
- (id<DrapiKotlinx_coroutines_core_nativeJob>)getScheduleNowNextId:(NSString *)id callback:(DrapiKotlinUnit *(^)(DrapiMuNowNext *))callback __attribute__((swift_name("getScheduleNowNext(id:callback:)")));
- (id<DrapiKotlinx_coroutines_core_nativeJob>)getScheduleNowNextCallback:(DrapiKotlinUnit *(^)(NSArray<DrapiMuNowNext *> *))callback __attribute__((swift_name("getScheduleNowNext(callback:)")));
- (id<DrapiKotlinx_coroutines_core_nativeJob>)searchQuery:(NSString *)query callback:(DrapiKotlinUnit *(^)(DrapiSearchResult *))callback __attribute__((swift_name("search(query:callback:)")));
- (id<DrapiKotlinx_coroutines_core_nativeJob>)getMostViewedChannel:(NSString *)channel channelType:(NSString *)channelType limit:(int32_t)limit callback:(DrapiKotlinUnit *(^)(DrapiMostViewed *))callback __attribute__((swift_name("getMostViewed(channel:channelType:limit:callback:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrMuApiKt")))
@interface DrapiDrMuApiKt : KotlinBase
@property (class, readonly) NSString *API_VERSION;
@property (class, readonly) NSString *API_URL;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrMuRepositoryKt")))
@interface DrapiDrMuRepositoryKt : KotlinBase
@property (class, readonly) int64_t defaultCacheSize;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeEncoder")))
@protocol DrapiKotlinx_serialization_runtime_nativeEncoder
@required
- (id<DrapiKotlinx_serialization_runtime_nativeCompositeEncoder>)beginCollectionDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc collectionSize:(int32_t)collectionSize typeParams:(DrapiKotlinArray *)typeParams __attribute__((swift_name("beginCollection(desc:collectionSize:typeParams:)")));
- (id<DrapiKotlinx_serialization_runtime_nativeCompositeEncoder>)beginStructureDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc typeParams:(DrapiKotlinArray *)typeParams __attribute__((swift_name("beginStructure(desc:typeParams:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescription:(DrapiKotlinx_serialization_runtime_nativeEnumDescriptor *)enumDescription ordinal:(int32_t)ordinal __attribute__((swift_name("encodeEnum(enumDescription:ordinal:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));
- (void)encodeNull __attribute__((swift_name("encodeNull()")));
- (void)encodeNullableSerializableValueSerializer:(id<DrapiKotlinx_serialization_runtime_nativeSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<DrapiKotlinx_serialization_runtime_nativeSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
- (void)encodeUnit __attribute__((swift_name("encodeUnit()")));
@property (readonly) id<DrapiKotlinx_serialization_runtime_nativeSerialContext> context;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeSerialDescriptor")))
@protocol DrapiKotlinx_serialization_runtime_nativeSerialDescriptor
@required
- (NSArray<id<DrapiKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));
- (id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));
- (NSArray<id<DrapiKotlinAnnotation>> *)getEntityAnnotations __attribute__((swift_name("getEntityAnnotations()")));
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));
@property (readonly) int32_t elementsCount;
@property (readonly) BOOL isNullable;
@property (readonly) DrapiKotlinx_serialization_runtime_nativeSerialKind *kind;
@property (readonly) NSString *name;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeDecoder")))
@protocol DrapiKotlinx_serialization_runtime_nativeDecoder
@required
- (id<DrapiKotlinx_serialization_runtime_nativeCompositeDecoder>)beginStructureDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc typeParams:(DrapiKotlinArray *)typeParams __attribute__((swift_name("beginStructure(desc:typeParams:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescription:(DrapiKotlinx_serialization_runtime_nativeEnumDescriptor *)enumDescription __attribute__((swift_name("decodeEnum(enumDescription:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));
- (DrapiKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<DrapiKotlinx_serialization_runtime_nativeDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<DrapiKotlinx_serialization_runtime_nativeDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
- (void)decodeUnit __attribute__((swift_name("decodeUnit()")));
- (id _Nullable)updateNullableSerializableValueDeserializer:(id<DrapiKotlinx_serialization_runtime_nativeDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateNullableSerializableValue(deserializer:old:)")));
- (id _Nullable)updateSerializableValueDeserializer:(id<DrapiKotlinx_serialization_runtime_nativeDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateSerializableValue(deserializer:old:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtime_nativeSerialContext> context;
@property (readonly) DrapiKotlinx_serialization_runtime_nativeUpdateMode *updateMode;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface DrapiKotlinArray : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size init:(id _Nullable (^)(DrapiInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (id _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<DrapiKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(id _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size;
@end;

__attribute__((swift_name("Kotlinx_ioCloseable")))
@protocol DrapiKotlinx_ioCloseable
@required
- (void)close __attribute__((swift_name("close()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClient")))
@interface DrapiKtor_client_coreHttpClient : KotlinBase <DrapiKotlinx_coroutines_core_nativeCoroutineScope, DrapiKotlinx_ioCloseable>
- (instancetype)initWithEngine:(id<DrapiKtor_client_coreHttpClientEngine>)engine userConfig:(DrapiKtor_client_coreHttpClientConfig *)userConfig __attribute__((swift_name("init(engine:userConfig:)"))) __attribute__((objc_designated_initializer));
- (DrapiKtor_client_coreHttpClient *)configBlock:(DrapiKotlinUnit *(^)(DrapiKtor_client_coreHttpClientConfig *))block __attribute__((swift_name("config(block:)")));
@property (readonly) id<DrapiKtor_utilsAttributes> attributes;
@property (readonly) DrapiKotlinx_coroutines_core_nativeCoroutineDispatcher *dispatcher;
@property (readonly) DrapiKtor_client_coreHttpClientEngineConfig *engineConfig;
@property (readonly) DrapiKtor_client_coreHttpReceivePipeline *receivePipeline;
@property (readonly) DrapiKtor_client_coreHttpRequestPipeline *requestPipeline;
@property (readonly) DrapiKtor_client_coreHttpResponsePipeline *responsePipeline;
@property (readonly) DrapiKtor_client_coreHttpSendPipeline *sendPipeline;
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
@property (readonly) id<DrapiKotlinCoroutineContextKey> key;
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeJob")))
@protocol DrapiKotlinx_coroutines_core_nativeJob <DrapiKotlinCoroutineContextElement>
@required
- (id<DrapiKotlinx_coroutines_core_nativeChildHandle>)attachChildChild:(id<DrapiKotlinx_coroutines_core_nativeChildJob>)child __attribute__((swift_name("attachChild(child:)")));
- (void)cancel __attribute__((swift_name("cancel()")));
- (BOOL)cancelCause:(DrapiKotlinThrowable * _Nullable)cause __attribute__((swift_name("cancel(cause:)")));
- (BOOL)cancel0 __attribute__((swift_name("cancel0()")));
- (DrapiKotlinx_coroutines_core_nativeCancellationException *)getCancellationException __attribute__((swift_name("getCancellationException()")));
- (id<DrapiKotlinx_coroutines_core_nativeDisposableHandle>)invokeOnCompletionOnCancelling:(BOOL)onCancelling invokeImmediately:(BOOL)invokeImmediately handler:(DrapiKotlinUnit *(^)(DrapiKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(onCancelling:invokeImmediately:handler:)")));
- (id<DrapiKotlinx_coroutines_core_nativeDisposableHandle>)invokeOnCompletionHandler:(DrapiKotlinUnit *(^)(DrapiKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(handler:)")));
- (id<DrapiKotlinx_coroutines_core_nativeJob>)plusOther:(id<DrapiKotlinx_coroutines_core_nativeJob>)other __attribute__((swift_name("plus(other:)")));
- (BOOL)start __attribute__((swift_name("start()")));
@property (readonly) id<DrapiKotlinSequence> children;
@property (readonly) BOOL isActive;
@property (readonly) BOOL isCancelled;
@property (readonly) BOOL isCompleted;
@property (readonly) id<DrapiKotlinx_coroutines_core_nativeSelectClause0> onJoin;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinUnit")))
@interface DrapiKotlinUnit : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)unit __attribute__((swift_name("init()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeCompositeEncoder")))
@protocol DrapiKotlinx_serialization_runtime_nativeCompositeEncoder
@required
- (void)encodeBooleanElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(desc:index:value:)")));
- (void)encodeByteElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(desc:index:value:)")));
- (void)encodeCharElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(desc:index:value:)")));
- (void)encodeDoubleElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(desc:index:value:)")));
- (void)encodeFloatElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(desc:index:value:)")));
- (void)encodeIntElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(desc:index:value:)")));
- (void)encodeLongElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(desc:index:value:)")));
- (void)encodeNonSerializableElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(id)value __attribute__((swift_name("encodeNonSerializableElement(desc:index:value:)")));
- (void)encodeNullableSerializableElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index serializer:(id<DrapiKotlinx_serialization_runtime_nativeSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(desc:index:serializer:value:)")));
- (void)encodeSerializableElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index serializer:(id<DrapiKotlinx_serialization_runtime_nativeSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(desc:index:serializer:value:)")));
- (void)encodeShortElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(desc:index:value:)")));
- (void)encodeStringElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(desc:index:value:)")));
- (void)encodeUnitElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("encodeUnitElement(desc:index:)")));
- (void)endStructureDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc __attribute__((swift_name("endStructure(desc:)")));
- (BOOL)shouldEncodeElementDefaultDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(desc:index:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtime_nativeSerialContext> context;
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeSerialClassDescImpl")))
@interface DrapiKotlinx_serialization_runtime_nativeSerialClassDescImpl : KotlinBase <DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>
- (instancetype)initWithName:(NSString *)name generatedSerializer:(id<DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer> _Nullable)generatedSerializer __attribute__((swift_name("init(name:generatedSerializer:)"))) __attribute__((objc_designated_initializer));
- (void)addElementName:(NSString *)name isOptional:(BOOL)isOptional __attribute__((swift_name("addElement(name:isOptional:)")));
- (void)pushAnnotationA:(id<DrapiKotlinAnnotation>)a __attribute__((swift_name("pushAnnotation(a:)")));
- (void)pushClassAnnotationA:(id<DrapiKotlinAnnotation>)a __attribute__((swift_name("pushClassAnnotation(a:)")));
- (void)pushDescriptorDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc __attribute__((swift_name("pushDescriptor(desc:)")));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeEnumDescriptor")))
@interface DrapiKotlinx_serialization_runtime_nativeEnumDescriptor : DrapiKotlinx_serialization_runtime_nativeSerialClassDescImpl
- (instancetype)initWithName:(NSString *)name choices:(DrapiKotlinArray *)choices __attribute__((swift_name("init(name:choices:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithName:(NSString *)name generatedSerializer:(id<DrapiKotlinx_serialization_runtime_nativeGeneratedSerializer> _Nullable)generatedSerializer __attribute__((swift_name("init(name:generatedSerializer:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeSerialContext")))
@protocol DrapiKotlinx_serialization_runtime_nativeSerialContext
@required
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer> _Nullable)getKclass:(id<DrapiKotlinKClass>)kclass __attribute__((swift_name("get(kclass:)")));
- (id<DrapiKotlinx_serialization_runtime_nativeKSerializer> _Nullable)getByValueValue:(id)value __attribute__((swift_name("getByValue(value:)")));
@end;

__attribute__((swift_name("KotlinAnnotation")))
@protocol DrapiKotlinAnnotation
@required
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeSerialKind")))
@interface DrapiKotlinx_serialization_runtime_nativeSerialKind : KotlinBase
@end;

__attribute__((swift_name("Kotlinx_serialization_runtime_nativeCompositeDecoder")))
@protocol DrapiKotlinx_serialization_runtime_nativeCompositeDecoder
@required
- (BOOL)decodeBooleanElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(desc:index:)")));
- (int8_t)decodeByteElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeByteElement(desc:index:)")));
- (unichar)decodeCharElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeCharElement(desc:index:)")));
- (int32_t)decodeCollectionSizeDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc __attribute__((swift_name("decodeCollectionSize(desc:)")));
- (double)decodeDoubleElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(desc:index:)")));
- (int32_t)decodeElementIndexDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc __attribute__((swift_name("decodeElementIndex(desc:)")));
- (float)decodeFloatElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeFloatElement(desc:index:)")));
- (int32_t)decodeIntElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeIntElement(desc:index:)")));
- (int64_t)decodeLongElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeLongElement(desc:index:)")));
- (id _Nullable)decodeNullableSerializableElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index deserializer:(id<DrapiKotlinx_serialization_runtime_nativeDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableElement(desc:index:deserializer:)")));
- (id _Nullable)decodeSerializableElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index deserializer:(id<DrapiKotlinx_serialization_runtime_nativeDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableElement(desc:index:deserializer:)")));
- (int16_t)decodeShortElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeShortElement(desc:index:)")));
- (NSString *)decodeStringElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeStringElement(desc:index:)")));
- (void)decodeUnitElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index __attribute__((swift_name("decodeUnitElement(desc:index:)")));
- (void)endStructureDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc __attribute__((swift_name("endStructure(desc:)")));
- (id _Nullable)updateNullableSerializableElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index deserializer:(id<DrapiKotlinx_serialization_runtime_nativeDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateNullableSerializableElement(desc:index:deserializer:old:)")));
- (id _Nullable)updateSerializableElementDesc:(id<DrapiKotlinx_serialization_runtime_nativeSerialDescriptor>)desc index:(int32_t)index deserializer:(id<DrapiKotlinx_serialization_runtime_nativeDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateSerializableElement(desc:index:deserializer:old:)")));
@property (readonly) id<DrapiKotlinx_serialization_runtime_nativeSerialContext> context;
@property (readonly) DrapiKotlinx_serialization_runtime_nativeUpdateMode *updateMode;
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
@interface DrapiKotlinEnum : KotlinBase <DrapiKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
- (int32_t)compareToOther:(DrapiKotlinEnum *)other __attribute__((swift_name("compareTo(other:)")));
@property (readonly) NSString *name;
@property (readonly) int32_t ordinal;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_runtime_nativeUpdateMode")))
@interface DrapiKotlinx_serialization_runtime_nativeUpdateMode : DrapiKotlinEnum
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
@property (class, readonly) DrapiKotlinx_serialization_runtime_nativeUpdateMode *banned;
@property (class, readonly) DrapiKotlinx_serialization_runtime_nativeUpdateMode *overwrite;
@property (class, readonly) DrapiKotlinx_serialization_runtime_nativeUpdateMode *update;
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (int32_t)compareToOther:(DrapiKotlinx_serialization_runtime_nativeUpdateMode *)other __attribute__((swift_name("compareTo(other:)")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol DrapiKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientEngine")))
@protocol DrapiKtor_client_coreHttpClientEngine <DrapiKotlinx_coroutines_core_nativeCoroutineScope, DrapiKotlinx_ioCloseable>
@required
@property (readonly) DrapiKtor_client_coreHttpClientEngineConfig *config;
@property (readonly) DrapiKotlinx_coroutines_core_nativeCoroutineDispatcher *dispatcher;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClientConfig")))
@interface DrapiKtor_client_coreHttpClientConfig : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (DrapiKtor_client_coreHttpClientConfig *)clone __attribute__((swift_name("clone()")));
- (void)engineBlock:(DrapiKotlinUnit *(^)(DrapiKtor_client_coreHttpClientEngineConfig *))block __attribute__((swift_name("engine(block:)")));
- (void)installClient:(DrapiKtor_client_coreHttpClient *)client __attribute__((swift_name("install(client:)")));
- (void)installFeature:(id<DrapiKtor_client_coreHttpClientFeature>)feature configure:(DrapiKotlinUnit *(^)(id))configure __attribute__((swift_name("install(feature:configure:)")));
- (void)installKey:(NSString *)key block:(DrapiKotlinUnit *(^)(DrapiKtor_client_coreHttpClient *))block __attribute__((swift_name("install(key:block:)")));
- (void)plusAssignOther:(DrapiKtor_client_coreHttpClientConfig *)other __attribute__((swift_name("plusAssign(other:)")));
@property BOOL expectSuccess;
@property BOOL followRedirects;
@property BOOL useDefaultTransformers;
@end;

__attribute__((swift_name("Ktor_utilsAttributes")))
@protocol DrapiKtor_utilsAttributes
@required
- (id)computeIfAbsentKey:(DrapiKtor_utilsAttributeKey *)key block:(id (^)(void))block __attribute__((swift_name("computeIfAbsent(key:block:)")));
- (BOOL)containsKey:(DrapiKtor_utilsAttributeKey *)key __attribute__((swift_name("contains(key:)")));
- (id)getKey_:(DrapiKtor_utilsAttributeKey *)key __attribute__((swift_name("get(key_:)")));
- (id _Nullable)getOrNullKey:(DrapiKtor_utilsAttributeKey *)key __attribute__((swift_name("getOrNull(key:)")));
- (void)putKey:(DrapiKtor_utilsAttributeKey *)key value:(id)value __attribute__((swift_name("put(key:value:)")));
- (void)removeKey:(DrapiKtor_utilsAttributeKey *)key __attribute__((swift_name("remove(key:)")));
- (id)takeKey:(DrapiKtor_utilsAttributeKey *)key __attribute__((swift_name("take(key:)")));
- (id _Nullable)takeOrNullKey:(DrapiKtor_utilsAttributeKey *)key __attribute__((swift_name("takeOrNull(key:)")));
@property (readonly) NSArray<DrapiKtor_utilsAttributeKey *> *allKeys;
@end;

__attribute__((swift_name("KotlinAbstractCoroutineContextElement")))
@interface DrapiKotlinAbstractCoroutineContextElement : KotlinBase <DrapiKotlinCoroutineContextElement>
- (instancetype)initWithKey:(id<DrapiKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinContinuationInterceptor")))
@protocol DrapiKotlinContinuationInterceptor <DrapiKotlinCoroutineContextElement>
@required
- (id<DrapiKotlinContinuation>)interceptContinuationContinuation:(id<DrapiKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (void)releaseInterceptedContinuationContinuation:(id<DrapiKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeCoroutineDispatcher")))
@interface DrapiKotlinx_coroutines_core_nativeCoroutineDispatcher : DrapiKotlinAbstractCoroutineContextElement <DrapiKotlinContinuationInterceptor>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithKey:(id<DrapiKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)dispatchContext:(id<DrapiKotlinCoroutineContext>)context block:(id<DrapiKotlinx_coroutines_core_nativeRunnable>)block __attribute__((swift_name("dispatch(context:block:)")));
- (void)dispatchYieldContext:(id<DrapiKotlinCoroutineContext>)context block:(id<DrapiKotlinx_coroutines_core_nativeRunnable>)block __attribute__((swift_name("dispatchYield(context:block:)")));
- (BOOL)isDispatchNeededContext:(id<DrapiKotlinCoroutineContext>)context __attribute__((swift_name("isDispatchNeeded(context:)")));
- (DrapiKotlinx_coroutines_core_nativeCoroutineDispatcher *)plusOther_:(DrapiKotlinx_coroutines_core_nativeCoroutineDispatcher *)other __attribute__((swift_name("plus(other_:)")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientEngineConfig")))
@interface DrapiKtor_client_coreHttpClientEngineConfig : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property DrapiKotlinx_coroutines_core_nativeCoroutineDispatcher * _Nullable dispatcher;
@property BOOL pipelining;
@property (readonly) DrapiKtor_client_coreHttpResponseConfig *response;
@property int32_t threadsCount;
@end;

__attribute__((swift_name("Ktor_utilsPipeline")))
@interface DrapiKtor_utilsPipeline : KotlinBase
- (instancetype)initWithPhase:(DrapiKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<DrapiKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhases:(DrapiKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer));
- (void)addPhasePhase:(DrapiKtor_utilsPipelinePhase *)phase __attribute__((swift_name("addPhase(phase:)")));
- (void)afterIntercepted __attribute__((swift_name("afterIntercepted()")));
- (void)insertPhaseAfterReference:(DrapiKtor_utilsPipelinePhase *)reference phase:(DrapiKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseAfter(reference:phase:)")));
- (void)insertPhaseBeforeReference:(DrapiKtor_utilsPipelinePhase *)reference phase:(DrapiKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseBefore(reference:phase:)")));
- (void)interceptPhase:(DrapiKtor_utilsPipelinePhase *)phase block:(id<DrapiKotlinSuspendFunction2>)block __attribute__((swift_name("intercept(phase:block:)")));
- (void)mergeFrom:(DrapiKtor_utilsPipeline *)from __attribute__((swift_name("merge(from:)")));
@property (readonly) id<DrapiKtor_utilsAttributes> attributes;
@property (readonly) BOOL isEmpty;
@property (readonly) NSArray<DrapiKtor_utilsPipelinePhase *> *items;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpReceivePipeline")))
@interface DrapiKtor_client_coreHttpReceivePipeline : DrapiKtor_utilsPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(DrapiKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<DrapiKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(DrapiKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestPipeline")))
@interface DrapiKtor_client_coreHttpRequestPipeline : DrapiKtor_utilsPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(DrapiKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<DrapiKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(DrapiKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponsePipeline")))
@interface DrapiKtor_client_coreHttpResponsePipeline : DrapiKtor_utilsPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(DrapiKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<DrapiKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(DrapiKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpSendPipeline")))
@interface DrapiKtor_client_coreHttpSendPipeline : DrapiKtor_utilsPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(DrapiKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<DrapiKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(DrapiKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol DrapiKotlinCoroutineContextKey
@required
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeDisposableHandle")))
@protocol DrapiKotlinx_coroutines_core_nativeDisposableHandle
@required
- (void)dispose __attribute__((swift_name("dispose()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeChildHandle")))
@protocol DrapiKotlinx_coroutines_core_nativeChildHandle <DrapiKotlinx_coroutines_core_nativeDisposableHandle>
@required
- (BOOL)childCancelledCause:(DrapiKotlinThrowable *)cause __attribute__((swift_name("childCancelled(cause:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeChildJob")))
@protocol DrapiKotlinx_coroutines_core_nativeChildJob <DrapiKotlinx_coroutines_core_nativeJob>
@required
- (void)parentCancelledParentJob:(id<DrapiKotlinx_coroutines_core_nativeParentJob>)parentJob __attribute__((swift_name("parentCancelled(parentJob:)")));
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

__attribute__((swift_name("Kotlinx_coroutines_core_nativeCancellationException")))
@interface DrapiKotlinx_coroutines_core_nativeCancellationException : DrapiKotlinIllegalStateException
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

__attribute__((swift_name("Kotlinx_coroutines_core_nativeSelectClause0")))
@protocol DrapiKotlinx_coroutines_core_nativeSelectClause0
@required
- (void)registerSelectClause0Select:(id<DrapiKotlinx_coroutines_core_nativeSelectInstance>)select block:(id<DrapiKotlinSuspendFunction0>)block __attribute__((swift_name("registerSelectClause0(select:block:)")));
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
@property (readonly) NSString * _Nullable qualifiedName;
@property (readonly) NSString * _Nullable simpleName;
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientFeature")))
@protocol DrapiKtor_client_coreHttpClientFeature
@required
- (void)installFeature:(id)feature scope:(DrapiKtor_client_coreHttpClient *)scope __attribute__((swift_name("install(feature:scope:)")));
- (id)prepareBlock:(DrapiKotlinUnit *(^)(id))block __attribute__((swift_name("prepare(block:)")));
@property (readonly) DrapiKtor_utilsAttributeKey *key;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsAttributeKey")))
@interface DrapiKtor_utilsAttributeKey : KotlinBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
@property (readonly) NSString *name;
@end;

__attribute__((swift_name("KotlinContinuation")))
@protocol DrapiKotlinContinuation
@required
- (void)resumeWithResult:(id _Nullable)result __attribute__((swift_name("resumeWith(result:)")));
@property (readonly) id<DrapiKotlinCoroutineContext> context;
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeRunnable")))
@protocol DrapiKotlinx_coroutines_core_nativeRunnable
@required
- (void)run __attribute__((swift_name("run()")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpResponseConfig")))
@interface DrapiKtor_client_coreHttpResponseConfig : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property DrapiKotlinx_ioCharset *defaultCharset;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsPipelinePhase")))
@interface DrapiKtor_utilsPipelinePhase : KotlinBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
@property (readonly) NSString *name;
@end;

__attribute__((swift_name("KotlinSuspendFunction")))
@protocol DrapiKotlinSuspendFunction
@required
@end;

__attribute__((swift_name("KotlinSuspendFunction2")))
@protocol DrapiKotlinSuspendFunction2 <DrapiKotlinSuspendFunction>
@required
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeParentJob")))
@protocol DrapiKotlinx_coroutines_core_nativeParentJob <DrapiKotlinx_coroutines_core_nativeJob>
@required
- (DrapiKotlinThrowable *)getChildJobCancellationCause __attribute__((swift_name("getChildJobCancellationCause()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeSelectInstance")))
@protocol DrapiKotlinx_coroutines_core_nativeSelectInstance
@required
- (void)disposeOnSelectHandle:(id<DrapiKotlinx_coroutines_core_nativeDisposableHandle>)handle __attribute__((swift_name("disposeOnSelect(handle:)")));
- (id _Nullable)performAtomicIfNotSelectedDesc:(DrapiKotlinx_coroutines_core_nativeAtomicDesc *)desc __attribute__((swift_name("performAtomicIfNotSelected(desc:)")));
- (id _Nullable)performAtomicTrySelectDesc:(DrapiKotlinx_coroutines_core_nativeAtomicDesc *)desc __attribute__((swift_name("performAtomicTrySelect(desc:)")));
- (void)resumeSelectCancellableWithExceptionException:(DrapiKotlinThrowable *)exception __attribute__((swift_name("resumeSelectCancellableWithException(exception:)")));
- (BOOL)trySelectIdempotent:(id _Nullable)idempotent __attribute__((swift_name("trySelect(idempotent:)")));
@property (readonly) id<DrapiKotlinContinuation> completion;
@property (readonly) BOOL isSelected;
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
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeAtomicDesc")))
@interface DrapiKotlinx_coroutines_core_nativeAtomicDesc : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeOp:(DrapiKotlinx_coroutines_core_nativeAtomicOp *)op failure:(id _Nullable)failure __attribute__((swift_name("complete(op:failure:)")));
- (id _Nullable)prepareOp:(DrapiKotlinx_coroutines_core_nativeAtomicOp *)op __attribute__((swift_name("prepare(op:)")));
@end;

__attribute__((swift_name("Kotlinx_ioCharsetDecoder")))
@interface DrapiKotlinx_ioCharsetDecoder : KotlinBase
- (instancetype)initWith_charset:(DrapiKotlinx_ioCharset *)_charset __attribute__((swift_name("init(_charset:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_ioCharsetEncoder")))
@interface DrapiKotlinx_ioCharsetEncoder : KotlinBase
- (instancetype)initWith_charset:(DrapiKotlinx_ioCharset *)_charset __attribute__((swift_name("init(_charset:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeOpDescriptor")))
@interface DrapiKotlinx_coroutines_core_nativeOpDescriptor : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeAtomicOp")))
@interface DrapiKotlinx_coroutines_core_nativeAtomicOp : DrapiKotlinx_coroutines_core_nativeOpDescriptor
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeAffected:(id _Nullable)affected failure:(id _Nullable)failure __attribute__((swift_name("complete(affected:failure:)")));
- (id _Nullable)prepareAffected:(id _Nullable)affected __attribute__((swift_name("prepare(affected:)")));
- (BOOL)tryDecideDecision:(id _Nullable)decision __attribute__((swift_name("tryDecide(decision:)")));
@property (readonly) BOOL isDecided;
@end;

NS_ASSUME_NONNULL_END
